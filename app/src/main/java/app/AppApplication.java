package app;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.developer.sample.funds_transfer_api.*;
import com.visa.developer.sample.funds_transfer_api.model.*;
import com.visa.developer.sample.funds_transfer_api.api.FundsTransferApi;

@SpringBootApplication
@RestController
public class AppApplication {
	
	private static FundsTransferApi apiInstance;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppApplication.class, args);
		
		ApiClient apiClient = new ApiClient();
		apiClient.setUsername("P1M3UPUGQCAD3S994LHL21ENfrUfsEna144_pj7pWrORkLkNY");
		apiClient.setPassword("mL7teKgSyur8glB8dRJfO6P");
		apiClient.setKeystorePath("keys/keyAndCertBundle.jks");
		apiClient.setKeystorePassword("password");
		apiClient.setPrivateKeyPassword("password");
		
		apiInstance = new FundsTransferApi(apiClient);
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/sendGift/{senderAccNum}+{senderName}+{senderAddr}+{senderCity}+{senderPostalCode}+{recipientState}+{recipientPrimaryAccNum}+{recipientCardExpiryDate}+{amount}")
	public static ResponseEntity<String> sendGift(@PathVariable String senderAccNum, @PathVariable String senderName, @PathVariable String senderAddr, @PathVariable String senderCity, 
			@PathVariable String senderPostalCode, @PathVariable String recipientState, @PathVariable String recipientPrimaryAccNum, @PathVariable String recipientCardExpiryDate, @PathVariable Double amount) {
		
		PushfundspostPayload pushBody = new PushfundspostPayload();
		PullfundspostPayload pullBody = new PullfundspostPayload();
		//Generate numbers
		int systemsTraceAuditNumber = ThreadLocalRandom.current().nextInt(100000, 1000000);
		int uniqueIdCode = ThreadLocalRandom.current().nextInt(10000, 100000);
		initializeParams(pushBody, systemsTraceAuditNumber, uniqueIdCode, senderAccNum, senderName, senderAddr, senderCity,
				senderPostalCode, recipientState, recipientPrimaryAccNum, recipientCardExpiryDate, amount);
		initializeParams(pullBody, systemsTraceAuditNumber, uniqueIdCode, senderAccNum, senderName, senderAddr, senderCity,
				senderPostalCode, recipientState, recipientPrimaryAccNum, recipientCardExpiryDate, amount);
		
		try {
			ParameterizedTypeReference<PullfundspostResponse> typeRefPull = new ParameterizedTypeReference<PullfundspostResponse>() {};
			ParameterizedTypeReference<PushfundspostResponse> typeRefPush = new ParameterizedTypeReference<PushfundspostResponse>() {};
			PushfundspostResponse pushresult = apiInstance.postpushfunds(pushBody, typeRefPush, PushfundspostResponse.class, false);
			PullfundspostResponse pullresult = apiInstance.postpullfunds(pullBody, typeRefPull, PullfundspostResponse.class, false);
			return new ResponseEntity<String>(pushresult.toString(), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	private static void initializeParams(PullfundspostPayload body, int systemsTraceAuditNumber, int uniqueIdCode,
			String senderAccountNum, String senderName, String senderAddr, String senderCity, 
			String senderPostalCode, String recipientState, String recipientPrimaryAccountNum, String recipientCardExpiryDate, Double amount) {
		
		body.setSystemsTraceAuditNumber(systemsTraceAuditNumber); //Unique value for each api call
		body.setRetrievalReferenceNumber(generateRetrievalReferenceNum(Integer.toString(systemsTraceAuditNumber)));
		body.setLocalTransactionDateTime(ZonedDateTime.now().toString().substring(0, 19));
		body.setAcquiringBin(408999);
		body.setAcquirerCountryCode(840);
		body.setSenderAccountNumber(senderAccountNum);
		body.setSenderCardExpiryDate("2025-03");
		body.setSenderCurrencyCode("USD");
		body.setSenderPostalCode(senderPostalCode);
		body.setSenderAddress(senderAddr);
		body.setSenderCity(senderCity);
		body.setSenderStateCode("CA");
		body.setRecipientState(recipientState);
		body.setRecipientCountryCode("840");
		body.setSenderPrimaryAccountNumber(recipientPrimaryAccountNum);
		body.setSenderCardExpiryDate(recipientCardExpiryDate);
		body.setAmount(amount);
		body.setBusinessApplicationId("AA");
		body.setMerchantCategoryCode(6012);
		//body.setSourceOfFunds("01");
		body.businessApplicationId("AA");
		//Create Card Acceptor Object
		CardAcceptor cardAcceptor = new CardAcceptor();
		cardAcceptor.setName(senderName);
		cardAcceptor.setTerminalId("365529");
		cardAcceptor.setIdCode("VisaTouch-"+uniqueIdCode);
		Address address = new Address();
		address.setState("CA");
		address.setCounty("San Mateo");
		address.setCountry("USA");
		address.setZipCode("94404");
		cardAcceptor.setAddress(address);
		
		body.setCardAcceptor(cardAcceptor);
	}
	
	private static void initializeParams(PushfundspostPayload body, int systemsTraceAuditNumber, int uniqueIdCode,
			String senderAccountNum, String senderName, String senderAddr, String senderCity, 
			String senderPostalCode, String recipientState, String recipientPrimaryAccountNum, String recipientCardExpiryDate, Double amount) {
		
		body.setSystemsTraceAuditNumber(systemsTraceAuditNumber); //Unique value for each api call
		body.setRetrievalReferenceNumber(generateRetrievalReferenceNum(Integer.toString(systemsTraceAuditNumber)));
		body.setLocalTransactionDateTime(ZonedDateTime.now().toString().substring(0, 19));
		body.setAcquiringBin(408999);
		body.setAcquirerCountryCode(840);
		body.setSenderAccountNumber(senderAccountNum);
		body.setTransactionCurrencyCode("USD");
		body.setSenderName(senderName);
		body.setSenderAddress(senderAddr);
		body.setSenderCity(senderCity);
		body.setSenderStateCode("CA");
		body.setSenderPostalCode(senderPostalCode);
		body.setRecipientState(recipientState);
		body.setRecipientCountryCode("840");
		body.setRecipientPrimaryAccountNumber(recipientPrimaryAccountNum);
		body.setRecipientCardExpiryDate(recipientCardExpiryDate);
		body.setAmount(amount);
		body.setBusinessApplicationId("AA");
		body.setMerchantCategoryCode(6012);
		body.setSourceOfFundsCode("01");
		//Create Card Acceptor Object
		CardAcceptor cardAcceptor = new CardAcceptor();
		cardAcceptor.setName(senderName);
		cardAcceptor.setTerminalId("365529");
		cardAcceptor.setIdCode("VisaTouch-"+uniqueIdCode);
		Address address = new Address();
		address.setState("CA");
		address.setCounty("San Mateo");
		address.setCountry("USA");
		address.setZipCode("94404");
		cardAcceptor.setAddress(address);
		
		body.setCardAcceptor(cardAcceptor);
	}
	
	//Format: ydddhhnnnnnn
	private static String generateRetrievalReferenceNum(String sixdigits) { 
		StringBuilder refNum = new StringBuilder();
		refNum.append(Year.now(ZoneId.of("America/New_York")).getValue() % 10); //Appends last digit of current years
		String dayOfYear = Integer.toString(LocalDate.now(ZoneId.of("America/New_York")).getDayOfYear()); //Append day of year (ddd)
		for (int i = dayOfYear.length(); i < 3; i++)
			refNum.append("0");
		refNum.append(dayOfYear);
		String hour = Integer.toString(LocalDateTime.now(ZoneId.of("America/New_York")).getHour()); //Append current hour (hh)
		if (hour.length() < 2)
			refNum.append("0");
		refNum.append(hour);
		refNum.append(sixdigits); //append nnnnnn
		
		return refNum.toString();
	}


}
