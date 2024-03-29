package com.example.conexion_api.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conexion_api.MainActivity;
import com.example.conexion_api.R;
import com.example.conexion_api.fragments.DeleteFragment;
import com.example.conexion_api.interfaces.CRUDInterface;
import com.example.conexion_api.interfaces.DeleteInterface;
import com.example.conexion_api.model.Product;
import com.example.conexion_api.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity implements DeleteInterface {

    TextView idText;
    TextView nameText;
    TextView priceText;
    Button editButton;
    Button deleteButton;

    CRUDInterface crudInterface;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        idText = (TextView) findViewById(R.id.idText);
        nameText = (TextView) findViewById(R.id.nameText);
        priceText = (TextView) findViewById(R.id.priceText);
        int id = getIntent().getExtras().getInt("id");
        editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callEdit();
            }
        });

        deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDeleteDialog(product.getId());
            }
        });

        getOne(id);

    }

    private void getOne(int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        crudInterface = retrofit.create(CRUDInterface.class);
        Call<Product> call = crudInterface.getOne(id);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if(!response.isSuccessful()){
                    Toast toast = Toast.makeText(getApplicationContext(), response.message() , Toast.LENGTH_LONG);
                    toast.show();
                    Log.e("Response err:",response.message());
                    return;
                }
                product = response.body();
                idText.setText(String.valueOf(product.getId()));
                nameText.setText(product.getName());
                priceText.setText(String.valueOf(product.getPrice()));

            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage() , Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw err:",t.getMessage());
            }
        });
    }
    private void callEdit() {
        Intent intent = new Intent(getApplicationContext(), EditActiviy.class);
        intent.putExtra("product", product);
        startActivity(intent);

    }

    @Override
    public void showDeleteDialog(int id) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DeleteFragment deleteInterface = new DeleteFragment("Delete proeudct", product.getId(),this);
        deleteInterface.show(fragmentManager, "Alert");
    }

    @Override
    public void delete(int id) {
        crudInterface = getCrudInterface();
        Call<Product> call = crudInterface.delete(id);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if(!response.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG);
                    toast.show();
                    Log.e("Response err: ", response.message());
                    return;
                }
                product = response.body();
                Toast toast = Toast.makeText(getApplicationContext(), product.getName() + " deleted!!", Toast.LENGTH_LONG);
                toast.show();
                callMain();
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw err: ", t.getMessage());
            }
        });

    }

    private CRUDInterface getCrudInterface() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        return crudInterface;
    }

    private void callMain() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}