package com.example.prueba_api;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.example.prueba_api.models.Pokemon;
import com.example.prueba_api.models.PokemonRespuesta;
import com.example.prueba_api.pockeapi.pockeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="POKEDEX";
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();

    }

    private void obtenerDatos(){
        pockeapiService service = retrofit.create(pockeapiService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall =service.obtenerListaPokemon();
        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                if(response.isSuccessful()){
                    PokemonRespuesta pokemonRespuesta = response.body();
                    ArrayList<Pokemon> listaPokemon=pokemonRespuesta.getResults();

                    for (int i=0;i<listaPokemon.size();i++){
                        Pokemon p = listaPokemon.get(i);
                        Log.i(TAG, " Pokemon: " + p.getName());
                    }

                }else{
                    Log.e(TAG, " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Log.e(TAG," onFailure: "+ t.getMessage());
            }
        });
    }
}