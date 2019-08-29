package com.function.http.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import com.function.http.client.entity.UserEntity;
import com.google.gson.Gson;

public class HttpClientServiceV1
{
   private String usernameColonPassword = "This is unit test AES:fngWay36m8dCVbBDJLUYu94iwHy4NwxfizVZG5kH6h8=";

   private StringBuilder base_url;
   private boolean isHttps ;

   
   public HttpClientServiceV1(String address, String port, boolean isHttps) {
      
      base_url = new StringBuilder();
      this.isHttps = isHttps;
      if (this.isHttps) {
         base_url.append("https://");
      } else {
         base_url.append("http://");
      }
      
      base_url.append(address);
      
      if ((port != null) &&(!port.equals(""))) {
         base_url.append(":"+port);
      }
   }
   
   public UserEntity doAuthenticationById(String id) {
      String resultJson = sendGet(base_url.toString(), "/v1/users/" + id, "application/json");
      if (resultJson != null) {
         Gson gson = new Gson();
         UserEntity user = gson.fromJson(resultJson, UserEntity.class);
         System.out.println("---------------user name = " + user.getUserName());
      }
      return null;
   }
   
   
   public String sendGet(String host, String endpoint, String contentType) {
      String basicAuthPayload = "Basic " + Base64.getEncoder().encodeToString(usernameColonPassword.getBytes());

      BufferedReader httpResponseReader = null;
      try {
         if(isHttps) {
            TrustManager[] trustAllCerts =
               { new InsecureTrustManager() };
               HostnameVerifier allHostsValid = new InsecureHostnameVerifier();
               SSLContext sc = SSLContext.getInstance("SSL");
               sc.init(null, trustAllCerts, new SecureRandom());
               HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
               HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
         }
          String  url = host+endpoint;
          // Connect to the web server endpoint
          URL serverUrl = new URL(url);
          HttpURLConnection urlConnection = (HttpURLConnection) serverUrl.openConnection();
          // Set HTTP method as GET
          urlConnection.setRequestMethod("GET");
          // Include the HTTP Basic Authentication payload
          urlConnection.addRequestProperty("Authorization", basicAuthPayload);
          if (contentType!= null) {
              urlConnection.addRequestProperty("Content-Type", contentType);
          }
          // Read response from web server, which will trigger HTTP Basic Authentication request to be sent.
          httpResponseReader =
                  new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
          System.out.println(urlConnection.getResponseCode());
         if (urlConnection.getResponseCode() == 200)
         {
            String lineRead;
            while ((lineRead = httpResponseReader.readLine()) != null)
            {
               System.out.println(lineRead);
               return lineRead;
            }
         }

      } catch (IOException ioe) {
          ioe.printStackTrace();
      }
      catch (NoSuchAlgorithmException e)
      {
         e.printStackTrace();
      }
      catch (KeyManagementException e)
      {
         e.printStackTrace();
      } finally {

          if (httpResponseReader != null) {
              try {
                  httpResponseReader.close();
              } catch (IOException ioe) {
                 ioe.printStackTrace();
              }
          }
      }
      return null;
  }
   

   public static void main(String[] args)
   {
      HttpClientServiceV1 httpClient = new HttpClientServiceV1("localhost", "8181", false);
      httpClient.doAuthenticationById("1696");
   }
}
