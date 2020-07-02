package com.visa.springboot.authentication;

import com.visa.springboot.authentication.services.MyUserDetailsService;
import com.visa.springboot.authentication.util.JwtUtil;
import com.visa.springboot.controller.user_info_controller;
import com.visa.springboot.model.user_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class auth_controller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private user_info_controller userInfoController;

    @RequestMapping({"/hello"})
    public String hello() {
        return "Hello World";
    }

    @GetMapping(value = "/auth_user")
    public ResponseEntity<user_info> getUserLoggedIn() {
        return ResponseEntity.ok().body(userDetailsService.getCurrentUser());
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody authentication_request authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), userInfoController.convert(authenticationRequest.getPassword()))
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new authentication_response(jwt));
    }

}
