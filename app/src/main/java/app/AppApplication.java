package app;

import java.nio.charset.StandardCharsets;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppApplication.class, args);
		ApiClient apiClient = context.getBean(ApiClient.class);
		apiClient.setKeyStorePass("password");
		apiClient.setKeyPassword("password");
		apiClient.setKeyStorePath("keys/keyAndCertBundle.jks");
		try {
			apiClient.establishSSL();
			apiClient.setAuthHeader("P1M3UPUGQCAD3S994LHL21ENfrUfsEna144_pj7pWrORkLkNY", "mL7teKgSyur8glB8dRJfO6P");
			CloseableHttpResponse res = apiClient.sendGET("https://sandbox.api.visa.com/vdp/helloworld");
			String responseJSON = EntityUtils.toString(res.getEntity(), StandardCharsets.UTF_8);
			System.out.println(responseJSON);
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
