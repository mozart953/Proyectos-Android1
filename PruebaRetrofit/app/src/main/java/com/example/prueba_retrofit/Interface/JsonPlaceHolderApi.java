package com.example.prueba_retrofit.Interface;

import com.example.prueba_retrofit.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("posts")
    Call<List<Posts>> getPosts();

}
