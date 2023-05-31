package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText val1, val2;
    private TextView resultado ;
    private RadioButton rb1, rb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = (EditText) findViewById(R.id.txt_valor1);
        val2 = (EditText) findViewById(R.id.txt_valor2);
        resultado = (TextView) findViewById(R.id.txt_resultado);
        rb1 = (RadioButton) findViewById(R.id.rb_sumar);
        rb2 = (RadioButton) findViewById(R.id.rb_restar);
    }

    public void Calcular(View view){

        String valor1_String = val1.getText().toString();
        String valor2_String = val2.getText().toString();

        int valor1 = Integer.parseInt(valor1_String);
        int valor2 = Integer.parseInt(valor2_String);

        if(rb1.isChecked()==true){
            int suma = valor1+valor2;
            String res = String.valueOf(suma);
            resultado.setText(res);
        }
        else if(rb2.isChecked()==true){
            int resta = valor1-valor2;
            String res = String.valueOf(resta);
            resultado.setText(res);
        }



    }
}