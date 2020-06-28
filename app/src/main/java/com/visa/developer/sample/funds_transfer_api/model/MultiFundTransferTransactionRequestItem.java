/*
 * *© Copyright 2018 - 2020 Visa. All Rights Reserved.**
 *
 * NOTICE: The software and accompanying information and documentation (together, the “Software”) remain the property of and are proprietary to Visa and its suppliers and affiliates. The Software remains protected by intellectual property rights and may be covered by U.S. and foreign patents or patent applications. The Software is licensed and not sold.*
 *
 *  By accessing the Software you are agreeing to Visa's terms of use (developer.visa.com/terms) and privacy policy (developer.visa.com/privacy).In addition, all permissible uses of the Software must be in support of Visa products, programs and services provided through the Visa Developer Program (VDP) platform only (developer.visa.com). **THE SOFTWARE AND ANY ASSOCIATED INFORMATION OR DOCUMENTATION IS PROVIDED ON AN “AS IS,” “AS AVAILABLE,” “WITH ALL FAULTS” BASIS WITHOUT WARRANTY OR  CONDITION OF ANY KIND. YOUR USE IS AT YOUR OWN RISK.** All brand names are the property of their respective owners, used for identification purposes only, and do not imply product endorsement or affiliation with Visa. Any links to third party sites are for your information only and equally  do not constitute a Visa endorsement. Visa has no insight into and control over third party content and code and disclaims all liability for any such components, including continued availability and functionality. Benefits depend on implementation details and business factors and coding steps shown are exemplary only and do not reflect all necessary elements for the described capabilities. Capabilities and features are subject to Visa’s terms and conditions and may require development,implementation and resources by you based on your business and operational details. Please refer to the specific API documentation for details on the requirements, eligibility and geographic availability.*
 *
 * This Software includes programs, concepts and details under continuing development by Visa. Any Visa features,functionality, implementation, branding, and schedules may be amended, updated or canceled at Visa’s discretion.The timing of widespread availability of programs and functionality is also subject to a number of factors outside Visa’s control,including but not limited to deployment of necessary infrastructure by issuers, acquirers, merchants and mobile device manufacturers.*
 *
 */

package com.visa.developer.sample.funds_transfer_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class MultiFundTransferTransactionRequestItem {
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("cardAcceptor")
    private CardAcceptor cardAcceptor = null;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderReference")
    private String senderReference = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("recipientPrimaryAccountNumber")
    private String recipientPrimaryAccountNumber = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("recipientLastName")
    private String recipientLastName = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("nationalReimbursementFee")
    private Double nationalReimbursementFee = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderPostalCode")
    private String senderPostalCode = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderFirstName")
    private String senderFirstName = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderAccountNumber")
    private String senderAccountNumber = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("feeProgramIndicator")
    private String feeProgramIndicator = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderIdentificationNumberBusiness")
    private String senderIdentificationNumberBusiness = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("transactionCurrencyCode")
    private String transactionCurrencyCode = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("acquiringBin")
    private Integer acquiringBin = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("accountType")
    private String accountType = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("merchantPseudoAbaNumber")
    private String merchantPseudoAbaNumber = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("transactionIdentifier")
    private Long transactionIdentifier = null;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("retrievalReferenceNumber")
    private String retrievalReferenceNumber = null;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("localTransactionDateTime")
    private String localTransactionDateTime = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("recipientFirstName")
    private String recipientFirstName = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("amount")
    private Double amount = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderDateOfBirth")
    private String senderDateOfBirth = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("recipientMiddleInitial")
    private String recipientMiddleInitial = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("recipientCardExpiryDate")
    private String recipientCardExpiryDate = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("recipientCountryCode")
    private String recipientCountryCode = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderIdentificationNumberIndividual")
    private String senderIdentificationNumberIndividual = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("systemsTraceAuditNumber")
    private Integer systemsTraceAuditNumber = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderCountryCode")
    private String senderCountryCode = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderAddress")
    private String senderAddress = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderCity")
    private String senderCity = null;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderCardExpiryDate")
    private String senderCardExpiryDate = null;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderCurrencyCode")
    private String senderCurrencyCode = null;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("cavv")
    private String cavv = null;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderPrimaryAccountNumber")
    private String senderPrimaryAccountNumber = null;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("sourceOfFundsCode")
    private String sourceOfFundsCode = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("recipientName")
    private String recipientName = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderMiddleInitial")
    private String senderMiddleInitial = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderName")
    private String senderName = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("recipientState")
    private String recipientState = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("surcharge")
    private String surcharge = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderStateCode")
    private String senderStateCode = null;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("senderLastName")
    private String senderLastName = null;
}
