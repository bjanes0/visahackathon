package app;

import org.springframework.core.ParameterizedTypeReference;

import com.visa.developer.sample.funds_transfer_api.*;
import com.visa.developer.sample.funds_transfer_api.model.*;
import com.visa.developer.sample.funds_transfer_api.api.FundsTransferApi;

import java.time.*;

public class Test {

	public static void main(String[] args) {
		ApiClient apiClient = new ApiClient();
		apiClient.setUsername("P1M3UPUGQCAD3S994LHL21ENfrUfsEna144_pj7pWrORkLkNY");
		apiClient.setPassword("mL7teKgSyur8glB8dRJfO6P");
		apiClient.setKeystorePath("keys/keyAndCertBundle.jks");
		apiClient.setKeystorePassword("password");
		apiClient.setPrivateKeyPassword("password");
		apiClient.buildRestTemplate();
		
		FundsTransferApi apiInstance = new FundsTransferApi(apiClient);
		
		PushfundspostPayload body = new PushfundspostPayload();
		initializeParams(body);
		
		
		try {
			ParameterizedTypeReference<PushfundspostResponse> typeRef = new ParameterizedTypeReference<PushfundspostResponse>() {};
			PushfundspostResponse result = apiInstance.postpushfunds(body, typeRef, PushfundspostResponse.class, false);
			System.out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void initializeParams(PushfundspostPayload body) {
		int systemsTraceAuditNumber = 123456;
		int uniqueIdCode = 12345;
		String senderAccountNum = "4957030420210454";
		String senderName = "John Johnson";
		String senderAddr = "123 Fake St";
		String senderCity = "Foster City";
		String senderPostalCode = "12346";
		String recipientState = "NY";
		String recipientPrimaryAccountNum = "4957030420210462";
		String recipientCardExpiryDate = "2025-03";
		Double amount = 10.49;
		
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
