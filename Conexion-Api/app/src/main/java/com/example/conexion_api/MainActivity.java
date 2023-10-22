package com.example.conexion_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.conexion_api.activities.CreateActivity;
import com.example.conexion_api.adapter.ProductsAdapter;
import com.example.conexion_api.interfaces.CRUDInterface;
import com.example.conexion_api.model.Product;
import com.example.conexion_api.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Product> products;
    CRUDInterface crudInterface;

    ListView listView;
    FloatingActionButton createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callCreate();
            }
        });
        getAll();
    }

    private void getAll(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        Call<List<Product>> call = crudInterface.getAll();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(!response.isSuccessful()){
                    Toast toast = Toast.makeText(getApplicationContext(), response.message() , Toast.LENGTH_LONG);
                    toast.show();
                    Log.e("Response err:",response.message());
                    return;
                }
                products = response.body();
                ProductsAdapter productsAdapter = new ProductsAdapter(products, getApplicationContext());
                listView.setAdapter(productsAdapter);
                products.forEach(p-> Log.i("Prods",p.toString()));
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage() , Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw err:",t.getMessage());
            }
        });


    }

    private void callCreate() {
        Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
        startActivity(intent);
    }
}