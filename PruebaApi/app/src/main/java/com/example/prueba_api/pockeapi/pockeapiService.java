package com.example.prueba_api.pockeapi;

import com.example.prueba_api.models.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface pockeapiService {
    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon();
}
