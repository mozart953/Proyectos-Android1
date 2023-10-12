package com.example.conexion_api.interfaces;

import com.example.conexion_api.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CRUDInterface {
    @GET("product")
    Call<List<Product>> getAll();
}
