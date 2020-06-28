package app;

import java.nio.charset.StandardCharsets;
import java.util.*;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visa.developer.sample.funds_transfer_api.*;
import com.visa.developer.sample.funds_transfer_api.model.*;
import com.visa.developer.sample.funds_transfer_api.api.FundsTransferApi;

@SpringBootApplication
@RestController
public class AppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppApplication.class, args);
		
		ApiClient apiClient = new ApiClient();
		apiClient.setUsername("P1M3UPUGQCAD3S994LHL21ENfrUfsEna144_pj7pWrORkLkNY");
		apiClient.setPassword("mL7teKgSyur8glB8dRJfO6P");
		apiClient.setKeystorePath("keys/keyAndCertBundle.jks");
		apiClient.setKeystorePassword("password");
		apiClient.setPrivateKeyPassword("password");
		
		FundsTransferApi apiInstance = new FundsTransferApi(apiClient);
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Root page
	@GetMapping()
	public String visa(@RequestParam(value = "Word", defaultValue = "Vigilantes") String word) {
		return String.format("Visa %s", word);
	}


}
