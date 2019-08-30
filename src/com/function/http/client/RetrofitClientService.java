package com.function.http.client;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.function.http.client.entity.JobEntity;
import com.function.http.client.entity.UserEntity;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientService
{
   private StringBuilder base_url;
   private boolean isHttps ;

   public  Retrofit retrofit;
   private RetrofitApiInterface apiInterface;
   
   public RetrofitClientService(String address, String port, boolean isHttps) {
      
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
   
   public Retrofit getRetrofitClient() throws NoSuchAlgorithmException, KeyManagementException {
      //If condition to ensure we don't create multiple retrofit instances in a single application
      if (retrofit == null) {
         OkHttpClient.Builder builder = new OkHttpClient.Builder();
         
         if (isHttps) {
            // Install the all-trusting trust manager
            TrustManager[] trustAllCerts = { new InsecureTrustManager() };
            HostnameVerifier allHostsValid = new InsecureHostnameVerifier();
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, null);
         // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(allHostsValid);
         }
         builder.addInterceptor(new RetrofitBasicAuthInterceptor("This is unit test AES", "fngWay36m8dCVbBDJLUYu94iwHy4NwxfizVZG5kH6h8="));
         OkHttpClient client = builder.build();

          //Defining the Retrofit using Builder
          retrofit = new Retrofit.Builder()
              .baseUrl(base_url.toString()) //This is the only mandatory call on Builder object.
              .addConverterFactory(GsonConverterFactory.create()) // Convertor library used to convert response into POJO
              .client(client)
              .build();
      }
      return retrofit;
  }
   
   public UserEntity doAuthenticationById(String id){

      try
      {
         apiInterface = getRetrofitClient().create(RetrofitApiInterface.class);
         Call<UserEntity> call = apiInterface.doAuthentication(id);

         System.out.println("----------start service");
         Response<UserEntity> response = call.execute();
         if (response.code() == 200)
         {
            UserEntity user = response.body();
            System.out.println("----------username = " + user);
            return user;

         }
         else
         {
            String error = response.errorBody().string();
            System.out.println("----------error = " + error);

         }

      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (KeyManagementException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (NoSuchAlgorithmException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return null;
   }

   
   public boolean doEnrollment(UserEntity user) 
   {
      try
      {
         apiInterface = getRetrofitClient().create(RetrofitApiInterface.class);
         Call<ResponseBody> call  = apiInterface.doEnrollment(user);

         System.out.println("----------start service");
         Response<ResponseBody> response = call.execute();
         if (response.code() == 201)
         {
            ResponseBody responseBody = response.body();
            System.out.println("----------responseBody = " + responseBody);
            return true;

         }
         else
         {
            String error = response.errorBody().string();
            System.out.println("----------error = " + error);

         }

      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (KeyManagementException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (NoSuchAlgorithmException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return false;
   }
   
   
   public boolean doUnenrollment(String username) {
      try
      {
         apiInterface = getRetrofitClient().create(RetrofitApiInterface.class);
         Call<ResponseBody> call  = apiInterface.doUnenrollment(username);

         System.out.println("----------start service");
         Response<ResponseBody> response = call.execute();
         if (response.code() == 200)
         {
            ResponseBody responseBody = response.body();
            System.out.println("----------responseBody = " + responseBody);
            return true;

         }
         else
         {
            String error = response.errorBody().string();
            System.out.println("----------error = " + error);

         }

      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (KeyManagementException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (NoSuchAlgorithmException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return false;
   }
   
   
   public List<JobEntity> getJobList(String username, String department) {
      try
      {
         apiInterface = getRetrofitClient().create(RetrofitApiInterface.class);
         Call<List<JobEntity>> call  = apiInterface.getJobList(username, department);

         System.out.println("----------start service");
         Response<List<JobEntity>> response = call.execute();
         if (response.code() == 200)
         {
            List<JobEntity> jobList = response.body();
            System.out.println("----------responseBody = " + jobList);
            return jobList;

         }
         else
         {
            String error = response.errorBody().string();
            System.out.println("----------error = " + error);

         }

      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (KeyManagementException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (NoSuchAlgorithmException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return null;
   }
   
   public static void main(String[] args)
   {
      RetrofitClientService httpClient = new RetrofitClientService("localhost",
            "9191", true);
      httpClient.doAuthenticationById("16969");
      httpClient.getJobList("user01", "dev");
   }
}
