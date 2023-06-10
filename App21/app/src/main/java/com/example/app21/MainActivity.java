package com.example.app21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Seleccion(View view){
        switch (view.getId()){
            case R.id.fresas:
                Toast.makeText(this,"Estas son fresas",Toast.LENGTH_LONG).show();
                break;
            case R.id.manzanas:
                Toast.makeText(this,"Estas son manzanas",Toast.LENGTH_LONG).show();
                break;
            case R.id.pina:
                Toast.makeText(this,"Estas son pinas",Toast.LENGTH_LONG).show();
                break;
            case R.id.sandia:
                Toast.makeText(this,"Estas son sandias",Toast.LENGTH_LONG).show();
                break;
            case R.id.frambuesas:
                Toast.makeText(this,"Estas son frambuesas",Toast.LENGTH_LONG).show();
                break;
            case R.id.peras:
                Toast.makeText(this,"Estas son peras",Toast.LENGTH_LONG).show();
                break;
            case R.id.naranja:
                Toast.makeText(this,"Estas son naranjas",Toast.LENGTH_LONG).show();
                break;
            case R.id.cerezas:
                Toast.makeText(this,"Estas son cerezas",Toast.LENGTH_LONG).show();
                break;
            case R.id.banano:
                Toast.makeText(this,"Estas son bananos",Toast.LENGTH_LONG).show();
                break;
            case R.id.mangos:
                Toast.makeText(this,"Estas son mangos",Toast.LENGTH_LONG).show();
                break;
            case R.id.uvas:
                Toast.makeText(this,"Estas son uvas",Toast.LENGTH_LONG).show();
                break;
            case R.id.melon:
                Toast.makeText(this,"Estas son melones",Toast.LENGTH_LONG).show();
                break;
            case R.id.zarzamora:
                Toast.makeText(this,"Estas son zarzamora",Toast.LENGTH_LONG).show();
                break;

        }

    }
}