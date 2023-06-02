package com.example.app9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt1, edt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.txt_nombre);
        edt2 = (EditText) findViewById(R.id.txt_contrasena);
    }

    public void Registrar(View view){
        String nombre = edt1.getText().toString();
        String password = edt2.getText().toString();

        if(nombre.length()==0){
            Toast.makeText(this, "Debes ingresar un nombre", Toast.LENGTH_LONG).show();
        }
        if(password.length()==0){
            Toast.makeText(this,"Debes ingresar una password", Toast.LENGTH_LONG).show();
        }
        if(nombre.length() !=0 && password.length() !=0){
            Toast.makeText(this,"Registro en proceso... ", Toast.LENGTH_LONG).show();
        }
    }
}