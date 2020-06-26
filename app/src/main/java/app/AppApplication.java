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
			
			String json = " \r\n" + 
					"{\r\n" + 
					"\"acquirerCountryCode\": \"840\",\r\n" + 
					"\"acquiringBin\": \"408999\",\r\n" + 
					"\"amount\": \"124.02\",\r\n" + 
					"\"businessApplicationId\": \"AA\",\r\n" + 
					"\"cardAcceptor\": {\r\n" + 
					"\"address\": {\r\n" + 
					"\"country\": \"USA\",\r\n" + 
					"\"county\": \"081\",\r\n" + 
					"\"state\": \"CA\",\r\n" + 
					"\"zipCode\": \"94404\"\r\n" + 
					"},\r\n" + 
					"\"idCode\": \"ABCD1234ABCD123\",\r\n" + 
					"\"name\": \"Visa Inc. USA-Foster City\",\r\n" + 
					"\"terminalId\": \"ABCD1234\"\r\n" + 
					"},\r\n" + 
					"\"cavv\": \"0700100038238906000013405823891061668252\",\r\n" + 
					"\"foreignExchangeFeeTransaction\": \"11.99\",\r\n" + 
					"\"localTransactionDateTime\": \"2020-06-26T17:41:44\",\r\n" + 
					"\"retrievalReferenceNumber\": \"330000550000\",\r\n" + 
					"\"senderCardExpiryDate\": \"2015-10\",\r\n" + 
					"\"senderCurrencyCode\": \"USD\",\r\n" + 
					"\"senderPrimaryAccountNumber\": \"4895142232120006\",\r\n" + 
					"\"surcharge\": \"11.99\",\r\n" + 
					"\"systemsTraceAuditNumber\": \"451001\",\r\n" + 
					"\"nationalReimbursementFee\": \"11.22\",\r\n" + 
					"\"cpsAuthorizationCharacteristicsIndicator\": \"Y\",\r\n" + 
					"\"addressVerificationData\": {\r\n" + 
					"\"street\": \"XYZ St\",\r\n" + 
					"\"postalCode\": \"12345\"\r\n" + 
					"},\r\n" + 
					"\"settlementServiceIndicator\": \"9\",\r\n" + 
					"\"colombiaNationalServiceData\": {\r\n" + 
					"\"countryCodeNationalService\": \"170\",\r\n" + 
					"\"nationalReimbursementFee\": \"20.00\",\r\n" + 
					"\"nationalNetMiscAmountType\": \"A\",\r\n" + 
					"\"nationalNetReimbursementFeeBaseAmount\": \"20.00\",\r\n" + 
					"\"nationalNetMiscAmount\": \"10.00\",\r\n" + 
					"\"addValueTaxReturn\": \"10.00\",\r\n" + 
					"\"taxAmountConsumption\": \"10.00\",\r\n" + 
					"\"addValueTaxAmount\": \"10.00\",\r\n" + 
					"\"costTransactionIndicator\": \"0\",\r\n" + 
					"\"emvTransactionIndicator\": \"1\",\r\n" + 
					"\"nationalChargebackReason\": \"11\"\r\n" + 
					"},\r\n" + 
					"\"riskAssessmentData\": {\r\n" + 
					"\"delegatedAuthenticationIndicator\": true,\r\n" + 
					"\"lowValueExemptionIndicator\": true,\r\n" + 
					"\"traExemptionIndicator\": true,\r\n" + 
					"\"trustedMerchantExemptionIndicator\": true,\r\n" + 
					"\"scpExemptionIndicator\": true\r\n" + 
					"},\r\n" + 
					"\"visaMerchantIdentifier\": \"73625198\"\r\n" + 
					"}";
			
			
			CloseableHttpResponse res = apiClient.sendPOSTwithJSON("https://sandbox.api.visa.com/visadirect/fundstransfer/v1/pullfundstransactions", json);
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
