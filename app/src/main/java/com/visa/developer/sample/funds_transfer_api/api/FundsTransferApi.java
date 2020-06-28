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

package com.visa.developer.sample.funds_transfer_api.api;

import com.visa.developer.sample.funds_transfer_api.ApiClient;
import com.visa.developer.sample.funds_transfer_api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2019-03-27T10:55:08.119+05:30[Asia/Kolkata]")
@Component("com.visa.developer.sample.funds_transfer_api.api.FundsTransferApi")

public class FundsTransferApi {
    private ApiClient apiClient;

    public FundsTransferApi() {
        this(new ApiClient());
    }

    @Autowired
    public FundsTransferApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }


    /**
     * Read Multi Pull Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param statusIdentifier     Status Identifier
     * @param xClientTransactionId
     * @return MultipullfundstransactionsgetResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public MultipullfundstransactionsgetResponse getmultipullfundstransactions(String statusIdentifier) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'statusIdentifier' is set
        if (statusIdentifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'statusIdentifier' when calling getmultipullfundstransactions");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("statusIdentifier", statusIdentifier);
        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/multipullfundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("multipullfundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};

        ParameterizedTypeReference<MultipullfundstransactionsgetResponse> returnType = new ParameterizedTypeReference<MultipullfundstransactionsgetResponse>() {
        };
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType, MultipullfundstransactionsgetResponse.class);
    }

    /**
     * Read Multi Push Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param statusIdentifier Status Identifier
     * @return MultipushfundstransactionsgetResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public MultipushfundstransactionsgetResponse getmultipushfundstransactions(String statusIdentifier) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'statusIdentifier' is set
        if (statusIdentifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'statusIdentifier' when calling getmultipushfundstransactions");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("statusIdentifier", statusIdentifier);
        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/multipushfundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("multipushfundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};

        ParameterizedTypeReference<MultipushfundstransactionsgetResponse> returnType = new ParameterizedTypeReference<MultipushfundstransactionsgetResponse>() {
        };
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType, MultipushfundstransactionsgetResponse.class);
    }

    /**
     * Read Multi Reverse Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param statusIdentifier Status Identifier
     * @return MultireversefundstransactionsgetResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public MultireversefundstransactionsgetResponse getmultireversefundstransactions(String statusIdentifier) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'statusIdentifier' is set
        if (statusIdentifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'statusIdentifier' when calling getmultireversefundstransactions");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("statusIdentifier", statusIdentifier);
        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/multireversefundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("multireversefundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};

        ParameterizedTypeReference<MultireversefundstransactionsgetResponse> returnType = new ParameterizedTypeReference<MultireversefundstransactionsgetResponse>() {
        };
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType, MultireversefundstransactionsgetResponse.class);
    }

    /**
     * Read Pull Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param statusIdentifier Status Identifier
     * @return PullfundstransactionsgetResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PullfundstransactionsgetResponse getpullfundstransactions(String statusIdentifier) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'statusIdentifier' is set
        if (statusIdentifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'statusIdentifier' when calling getpullfundstransactions");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("statusIdentifier", statusIdentifier);
        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/pullfundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("pullfundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};

        ParameterizedTypeReference<PullfundstransactionsgetResponse> returnType = new ParameterizedTypeReference<PullfundstransactionsgetResponse>() {
        };
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType, PullfundstransactionsgetResponse.class);
    }

    /**
     * Read Push Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param statusIdentifier Status Identifier
     * @return PushfundstransactionsgetResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PushfundstransactionsgetResponse getpushfundstransactions(String statusIdentifier) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'statusIdentifier' is set
        if (statusIdentifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'statusIdentifier' when calling getpushfundstransactions");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("statusIdentifier", statusIdentifier);
        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/pushfundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("pushfundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};

        ParameterizedTypeReference<PushfundstransactionsgetResponse> returnType = new ParameterizedTypeReference<PushfundstransactionsgetResponse>() {
        };
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType, PushfundstransactionsgetResponse.class);
    }

    /**
     * Read Reverse Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param statusIdentifier Status Identifier
     * @return ReversefundstransactionsgetResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ReversefundstransactionsgetResponse getreversefundstransactions(String statusIdentifier) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'statusIdentifier' is set
        if (statusIdentifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'statusIdentifier' when calling getreversefundstransactions");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("statusIdentifier", statusIdentifier);
        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/reversefundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("reversefundstransactions/{statusIdentifier}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};

        ParameterizedTypeReference<ReversefundstransactionsgetResponse> returnType = new ParameterizedTypeReference<ReversefundstransactionsgetResponse>() {
        };
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType, ReversefundstransactionsgetResponse.class);
    }

    /**
     * Create Multi Pull Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param body                 Request body for creating in multi pull funds transfer
     * @param xClientTransactionId A unique value for a transaction (unique at the level of the individual service invoker and can be recycled every 24 hours). This identifies the transaction uniquely and can help reference the results of the original transaction.
     * @return MultipullfundspostResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String postmultipullfunds(MultipullfundspostPayload body, String xClientTransactionId, Boolean simulateTimeout) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling postmultipullfunds");
        }

        // verify the required parameter 'xClientTransactionId' is set
        if (xClientTransactionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xClientTransactionId' when calling postmultipullfunds");
        }

        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/multipullfundstransactions").build().toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("multipullfundstransactions").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (xClientTransactionId != null)
            headerParams.add("X-Client-Transaction-Id", apiClient.parameterToString(xClientTransactionId));

        if (simulateTimeout) {
            headerParams.add("X-TRANSACTION-TIMEOUT-MS", "1");
        }
        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
                "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {
        };
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType, String.class);
    }

    /**
     * Create Multi Push Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param body                 Request body for creating in multi push funds transfer
     * @param xClientTransactionId A unique value for a transaction (unique at the level of the individual service invoker and can be recycled every 24 hours). This identifies the transaction uniquely and can help reference the results of the original transaction.
     * @return MultipushfundspostResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String postmultipushfunds(MultipushfundspostPayload body, String xClientTransactionId) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling postmultipushfunds");
        }

        // verify the required parameter 'xClientTransactionId' is set
        if (xClientTransactionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xClientTransactionId' when calling postmultipushfunds");
        }

        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/multipushfundstransactions").build().toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("multipushfundstransactions").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (xClientTransactionId != null)
            headerParams.add("X-Client-Transaction-Id", apiClient.parameterToString(xClientTransactionId));

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
                "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {
        };
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType, String.class);
    }

    /**
     * Create Multi Reverse Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param body                 Request body for creating in multi reverse funds transfer
     * @param xClientTransactionId
     * @return MultireversefundspostResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String postmultireversefunds(MultireversefundspostPayload body, String xClientTransactionId) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling postmultireversefunds");
        }

        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/multireversefundstransactions").build().toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("multireversefundstransactions").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
                "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};
        if (xClientTransactionId != null)
            headerParams.add("X-Client-Transaction-Id", apiClient.parameterToString(xClientTransactionId));
        headerParams.add("X-TRANSACTION-TIMEOUT-MS", "1000000");

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {
        };
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType, String.class);
    }

    /**
     * Create Pull Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param body Request body for creating in pull funds transfer
     * @return PullfundspostResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public <T> T postpullfunds(PullfundspostPayload body, ParameterizedTypeReference<T> responseTypeReference, Class<T> responseClass, Boolean shouldSimulateTimeout) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling postpullfunds");
        }

        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/pullfundstransactions").build().toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("pullfundstransactions").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
                "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};
        if (shouldSimulateTimeout) {
            headerParams.add("X-TRANSACTION-TIMEOUT-MS", "1");
        }
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, responseTypeReference, responseClass);
    }

    /**
     * Create Push Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param body                     Request body for creating in push funds transfer
     * @param shouldTransactionTimeout
     * @return PushfundspostResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public <T> T postpushfunds(PushfundspostPayload body, ParameterizedTypeReference<T> responseTypeReference, Class<T> responseClass, Boolean shouldSimulateTimeout) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling postpushfunds");
        }

        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/pushfundstransactions").build().toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("pushfundstransactions").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
                "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};
        if (shouldSimulateTimeout) {
            headerParams.add("X-TRANSACTION-TIMEOUT-MS", "10");
        }
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, responseTypeReference, responseClass);

    }

    /**
     * Create Reverse Funds Transaction
     * <p><b>2XX</b> - Successful response object.
     *
     * @param body Request body for creating in reverse funds transfer
     * @return ReversefundspostResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public <T> T postreversefunds(ReversefundspostPayload body, ParameterizedTypeReference<T> responseType, Class<T> responseClass, Boolean shouldSimulateTimeout) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling postreversefunds");
        }

        String path = UriComponentsBuilder.fromPath("/visadirect/fundstransfer/v1/reversefundstransactions").build().toUriString();
        String resourcePath = UriComponentsBuilder.fromPath("reversefundstransactions").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
                "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{"basicAuth"};
        if (shouldSimulateTimeout) {
            headerParams.add("X-TRANSACTION-TIMEOUT-MS", "1");
        }
        return apiClient.invokeAPI(path, resourcePath, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, responseType, responseClass);
    }

}

