package com.example.app11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_Nombre);
    }
    public void Enviar(View view){
        Intent enviar = new Intent(this, MainActivity2.class);
        enviar.putExtra("nombre", et1.getText().toString());
        startActivity(enviar);
    }
}