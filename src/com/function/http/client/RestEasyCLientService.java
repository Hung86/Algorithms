package com.function.http.client;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.function.http.client.entity.UserEntity;
import com.google.gson.Gson;

public class RestEasyCLientService
{
   private String usernameColonPassword = "This is unit test AES:fngWay36m8dCVbBDJLUYu94iwHy4NwxfizVZG5kH6h8=";

   private StringBuilder base_url;
   private boolean isHttps ;

   
   public RestEasyCLientService(String address, String port, boolean isHttps) {
      
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
      ResteasyClient client = new ResteasyClientBuilder().build();  
      ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget)client.target(base_url.toString() + "/v1/users").path(id);
      resteasyWebTarget.register(new BasicAuthentication("This is unit test AES", "fngWay36m8dCVbBDJLUYu94iwHy4NwxfizVZG5kH6h8="));
      Response response = resteasyWebTarget.request().get();
      if (response.getStatus() == 200) {
         String value = response.readEntity(String.class);
         Gson gson = new Gson();
         UserEntity user = gson.fromJson(value, UserEntity.class);
         System.out.println(user.getUserName());
         return user;
      }
      return null;
   }
   
   public static void main(String[] args)
   {
      RestEasyCLientService httpClient = new RestEasyCLientService("localhost", "8181", false);
      httpClient.doAuthenticationById("1696");
   }
}
