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

/*
 * Funds Transfer API
 * The Funds Transfer API can pull funds from the sender&apos;s Visa account (in preparation for pushing funds to a recipient&apos;s account) in an Account Funding Transaction (AFT).  Additionally, the Funds Transfer API also provides functionality to push funds to the recipient&apos;s Visa account in an Original Credit Transaction (OCT).  If a transaction is declined, the Funds Transfer API can also return the funds to the sender&apos;s funding source in an Account Funding Transaction Reversal (AFTR). The API has been enhanced to allow originators to send their PushFundsTransactions(OCTs) and PullFundsTransactions(AFTs) to Visa for routing to multiple U.S. debit networks.
 *
 * OpenAPI spec version: v1
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.visa.developer.sample.funds_transfer_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Request body for creating in multi pull funds transfer
 */
@ApiModel(description = "Request body for creating in multi pull funds transfer")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2019-03-27T10:55:08.119+05:30[Asia/Kolkata]")
public class MultipullfundspostPayload {


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("businessApplicationId")
    private String businessApplicationId = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("merchantCategoryCode")
    private Integer merchantCategoryCode = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("merchantVerificationValue")
    private MerchantVerificationValue merchantVerificationValue = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("sharingGroupCode")
    private String sharingGroupCode = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("acquirerCountryCode")
    private Integer acquirerCountryCode = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("acquiringBin")
    private Integer acquiringBin = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("cpsAuthorizationCharacteristicsIndicator")
    private String cpsAuthorizationCharacteristicsIndicator = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("merchantPseudoAbaNumber")
    private String merchantPseudoAbaNumber = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("localTransactionDateTime")
    private String localTransactionDateTime = null;


    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("systemsTraceAuditNumber")
    private Integer systemsTraceAuditNumber = null;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
    @JsonProperty("request")
    private List<MultiFundTransferTransactionRequestItem> request;


    public MultipullfundspostPayload businessApplicationId(String businessApplicationId) {
        this.businessApplicationId = businessApplicationId;
        return this;
    }


    /**
     * Identifies the programs&#x27; business application type for VisaNet transaction processing&lt;br&gt;&lt;br&gt;For Money Transfer, AA applies to transactions where the sender and recipient are the same person and PP applies to transactions where the sender and recipient are not the same person.&lt;br&gt;&lt;br&gt;Refer to &lt;a href&#x3D;\&quot;/request_response_codes#business_application_identifier\&quot;&gt;businessApplicationId&lt;/a&gt; codes
     *
     * @return businessApplicationId
     **/
    @ApiModelProperty(required = true, value = "Identifies the programs' business application type for VisaNet transaction processing<br><br>For Money Transfer, AA applies to transactions where the sender and recipient are the same person and PP applies to transactions where the sender and recipient are not the same person.<br><br>Refer to <a href=\"/request_response_codes#business_application_identifier\">businessApplicationId</a> codes")
    public String getBusinessApplicationId() {
        return businessApplicationId;
    }

    public void setBusinessApplicationId(String businessApplicationId) {
        this.businessApplicationId = businessApplicationId;
    }


    /**
     * when present, this field contain a valid &lt;a href&#x3D;\&quot;/request_response_codes#sourceOfFundsCode\&quot;&gt;sourceOfFundsCode&lt;/a&gt; code that matches the funding instrument. &lt;br&gt;&lt;br&gt;Refer to &lt;a href&#x3D;\&quot;/request_response_codes#sourceOfFundsCode\&quot;&gt;sourceOfFundsCode&lt;/a&gt; codes
     * @return sourceOfFunds
     **/
}



