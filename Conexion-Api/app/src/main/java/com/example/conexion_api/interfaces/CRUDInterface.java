package com.example.conexion_api.interfaces;

import com.example.conexion_api.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CRUDInterface {
    @GET("product")
    Call<List<Product>> getAll();

    @GET("product/{id}")
    Call<Product> getOne(@Path("id") int id);
}
