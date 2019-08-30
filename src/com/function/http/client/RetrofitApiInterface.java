package com.function.http.client;

import java.util.List;

import com.function.http.client.entity.JobEntity;
import com.function.http.client.entity.UserEntity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface  RetrofitApiInterface
{
   @GET("/v1/users/{id}")
   Call<UserEntity> doAuthentication(@Path("id") String id);
   
   @POST("/v1/users")
   Call<ResponseBody> doEnrollment(@Body UserEntity user);
   
   @DELETE("/v1/users/{username}")
   Call<ResponseBody> doUnenrollment(@Path("username") String username);
   
   @GET("/v1/users/{username}/{department}/jobs")
   Call<List<JobEntity>> getJobList(@Path("username") String username, @Path("department") String department);

}
