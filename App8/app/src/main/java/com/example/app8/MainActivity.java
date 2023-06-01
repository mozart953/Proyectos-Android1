package com.example.app8;

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

    public void metodo1(View view){
        Toast.makeText(this, "Metodo 1", Toast.LENGTH_LONG).show();
    }

    public void metodo2(View view){
        Toast.makeText(this, "Metodo 2", Toast.LENGTH_LONG).show();
    }
}