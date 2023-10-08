package com.example.segundapruebaretrofit.Service2;

import com.example.segundapruebaretrofit.Modelo.Model;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ModelApiService {
    @GET("/")
    List<Model> getAllModels();

    @POST("/")
    Model createModel(@Body Model model);

    @PUT("/")
    Model updateModel(@Body Model model);

    @DELETE("/")
    void deleteModel(@Path("id") int id);
}
}
