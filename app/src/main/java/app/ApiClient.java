package app;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Base64Utils;

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

        public void setKeyStorePass(String keyStorePath) {
                this.keyStorePass = keyStorePath;
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
                // HttpHeaders header = new HttpHeaders();
                // addAuthenticationToHeader(header, "P1M3UPUGQCAD3S994LHL21ENfrUfsEna144_pj7pWrORkLkNY", "mL7teKgSyur8glB8dRJfO6P");
                httpGet.addHeader(authHeader);
                return httpClient.execute(httpGet);
        }

        /* Establishes two way ssl using key store and key password */
        private void establishSSL() throws NoSuchAlgorithmException, KeyStoreException, 
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

        /* FOR QUICK TESTING (remove this before deploying) */
        public static void main(String[] args) {
                /*Example with HelloWorld GET request*/
                //First creates instance of apis with keystore
                ApiClient api = new ApiClient("app/keys/keyAndCertBundle.jks", "password", "password");
                try {
                        api.establishSSL(); //connect to visa api with ssl
                        api.setAuthHeader("P1M3UPUGQCAD3S994LHL21ENfrUfsEna144_pj7pWrORkLkNY", "mL7teKgSyur8glB8dRJfO6P"); //authentication info for every request
                        CloseableHttpResponse res = api.sendGET("https://sandbox.api.visa.com/vdp/helloworld");
                        String responseJSON = EntityUtils.toString(res.getEntity(), StandardCharsets.UTF_8);
                        System.out.println("\nResponse:");
                        System.out.println(responseJSON); //Prints JSON from GET
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
