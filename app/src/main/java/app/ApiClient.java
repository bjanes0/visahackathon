package app;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

@Component
public class ApiClient {

        private String keyStorePath;
        private String keyStorePass;
        private String keyPassword;
        private CloseableHttpClient httpClient;
        private Header authHeader;

        //Create empty api client
        public ApiClient() {}

        //Create api client with given key store
        public ApiClient(String keyStorePath, String keyStorePass, String keyPassword) {
                this.keyPassword = keyPassword;
                this.keyStorePass = keyStorePass;
                this.keyStorePath = keyStorePath;
        }

        public void setKeyStorePath(String keyStorePath) {
                this.keyStorePath = keyStorePath;
        }

        public void setKeyStorePass(String keyStorePass) {
                this.keyStorePass = keyStorePass;
        }
        
        public void setKeyPassword(String keyPassword) {
        	this.keyPassword = keyPassword;
        }

        public CloseableHttpClient getHttpClient() {
                return httpClient;
        }

        /* Sets the authentication header. Whenever a request is made, this header will be added to the request */
        public void setAuthHeader(String username, String password) {
                String str = (username == null ? "" : username) + ":" + (password == null ? "" : password); 
                authHeader = new BasicHeader("Authorization", "Basic " + Base64Utils.encodeToString(str.getBytes(StandardCharsets.UTF_8)));
        }

        /* Make sure Auth Header is set (use setAuthHeader()) prior to calling this method */
        public CloseableHttpResponse sendGET(String uri) throws IOException {
                HttpGet httpGet = new HttpGet(uri);
                httpGet.addHeader(authHeader);
                return httpClient.execute(httpGet);
        }
        
        /* Make sure Auth Header is set prior to calling this method */
        public CloseableHttpResponse sendPOST(String uri, List<NameValuePair> params) throws IOException {	
        	HttpPost httpPost = new HttpPost(uri);
        	httpPost.addHeader(authHeader);
        	httpPost.setEntity(new UrlEncodedFormEntity(params));
        	return httpClient.execute(httpPost);
        }
        
        /* Make sure Auth Header is set prior to calling this method */
        public CloseableHttpResponse sendPOSTwithJSON(String uri, String json) throws IOException {	
        	HttpPost httpPost = new HttpPost(uri);
        	httpPost.setHeader("Content-type", "application/json");
        	httpPost.addHeader(authHeader);
        	httpPost.setEntity(new StringEntity(json));
        	return httpClient.execute(httpPost);
        }
        

        /* Establishes two way ssl using key store and key password */
        public void establishSSL() throws NoSuchAlgorithmException, KeyStoreException, 
                        UnrecoverableKeyException, CertificateException, IOException, KeyManagementException {
                //Load client certificate into key store
                SSLContext sslcontext = SSLContexts.custom()
                        .loadKeyMaterial(new File(keyStorePath), keyStorePass.toCharArray(),
                                keyPassword.toCharArray())
                        .loadTrustMaterial(new File(keyStorePath), keyStorePass.toCharArray())
                        .build();
                
                // Allow TLSv1.2 protocol only
                SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1.2" }, null,
                        SSLConnectionSocketFactory.getDefaultHostnameVerifier());

                httpClient = HttpClients.custom()
                        .setSSLSocketFactory(sslSocketFactory).build();
                
                HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
        }
        
        /* Compiles all REQUIRED request attributes for a pull funds request into a list so that
         * sendPOST() can easily be called. All optional request attributes must be added to 
         * the list manually */
//        public String buildPullFundsParamJson() {
//        	JSONObject json = new JSONObject();
//        }
        

}
