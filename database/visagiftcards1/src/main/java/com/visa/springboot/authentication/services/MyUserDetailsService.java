package com.visa.springboot.authentication.services;

import com.visa.springboot.controller.user_info_controller;
import com.visa.springboot.model.user_info;
import com.visa.springboot.repository.user_info_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private user_info_repository userInfoRepository;
    private user_info curr_user;

    public user_info getCurrentUser() {
        return curr_user;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<user_info> users = userInfoRepository.findAll();
        for (user_info user : users) {
            if(userName.equals(user.getEmail())){
                curr_user = user;
                return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
            }
        }
        return new User(" ", " ", new ArrayList<>());
    }
}
