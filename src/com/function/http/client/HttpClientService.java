package com.function.http.client;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.function.http.client.entity.JobEntity;
import com.function.http.client.entity.UserEntity;

public class HttpClientService
{
   private StringBuilder base_url;
   private boolean isHttps ;

   
   public HttpClientService(String address, String port, boolean isHttps) {
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
   
   public UserEntity doAuthenticationById(String id)
   {
      HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(
                                             "This is unit test AES",
                                             "fngWay36m8dCVbBDJLUYu94iwHy4NwxfizVZG5kH6h8=");
      
      ClientConfig clientConfig = new ClientConfig();
      clientConfig.register(feature);
      Client client = null;
      if (isHttps) {
         client = createHttpsClient(clientConfig);
      } else {
         client = createHttpClient(clientConfig);
      }

      WebTarget webTarget = client.target(base_url.toString() + "/v1/users").path(id);

      Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
      Response response = invocationBuilder.get();
      
      System.out.println(response.getStatus());
      UserEntity user = null;
      if (response.getStatus() == 200) {
         user = response.readEntity(UserEntity.class);
         System.out.println(user.getUserName());
      }
      
      return user;
   }

   
   public boolean doEnrollment(UserEntity user) 
   {
      HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(
            "This is unit test AES",
            "fngWay36m8dCVbBDJLUYu94iwHy4NwxfizVZG5kH6h8=");

      ClientConfig clientConfig = new ClientConfig();
      clientConfig.register(feature);
      Client client = null;
      if (isHttps) {
         client = createHttpsClient(clientConfig);
      } else {
         client = createHttpClient(clientConfig);
      } 
       WebTarget webTarget = client.target(base_url.toString() + "/v1/users");
       
       Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
       Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
       
       System.out.println(response.getStatus());
       if (response.getStatus() == 201) {
          return true;
       }
       
       return false;
   }
   
   
   public boolean doUnenrollment(String username)
   {
      HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(
                                             "This is unit test AES",
                                             "fngWay36m8dCVbBDJLUYu94iwHy4NwxfizVZG5kH6h8=");
      
      ClientConfig clientConfig = new ClientConfig();
      clientConfig.register(feature);
      Client client = null;
      if (isHttps) {
         client = createHttpsClient(clientConfig);
      } else {
         client = createHttpClient(clientConfig);
      }

      WebTarget webTarget = client.target(base_url.toString() + "/v1/users").path(username);

      Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
      Response response = invocationBuilder.delete();
      
      System.out.println(response.getStatus());
      if (response.getStatus() == 201) {
         return true;
      }
      
      return false;
      
   }
   
   public List<JobEntity> getJobList(String username, String department)
   {
      HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(
                                             "This is unit test AES",
                                             "fngWay36m8dCVbBDJLUYu94iwHy4NwxfizVZG5kH6h8=");
      
      ClientConfig clientConfig = new ClientConfig();
      clientConfig.register(feature);
      Client client = null;
      if (isHttps) {
         client = createHttpsClient(clientConfig);
      } else {
         client = createHttpClient(clientConfig);
      }

      WebTarget webTarget = client.target(base_url.toString() + "/v1/users").path(username).path(department).path("jobs");

      Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
      Response response = invocationBuilder.get();
      
      System.out.println(response.getStatus());
      List<JobEntity> userList = null;
      if (response.getStatus() == 200) {
         userList = response.readEntity(new GenericType<List<JobEntity>>() {});
         System.out.println(userList.size());
      }
      
      return userList;
   }
   
   
   public Client createHttpClient(ClientConfig clientConfig) {
      return ClientBuilder.newClient(clientConfig);
   }
   
   
   public Client createHttpsClient(ClientConfig clientConfig) {
      SSLContext ctx = null;
      TrustManager[] trustAllCerts = { new InsecureTrustManager() };
      HostnameVerifier allHostsValid = new InsecureHostnameVerifier();

      try
      {
         ctx = SSLContext.getInstance("SSL");
         ctx.init(null, trustAllCerts, null);
      }
      catch (NoSuchAlgorithmException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (KeyManagementException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return ClientBuilder.newBuilder().withConfig(clientConfig).sslContext(ctx).hostnameVerifier(allHostsValid).build();
   }
   
   
   public static void main(String[] args)
   {
      HttpClientService httpClient = new HttpClientService("localhost", "9191", true);
      httpClient.doAuthenticationById("1696");
      httpClient.getJobList("user01", "dev");
   }
}
