package com.example.app6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText edt1, edt2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.txt_valor1);
        edt2 = (EditText) findViewById(R.id.txt_valor2);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        tv1 = (TextView) findViewById(R.id.txt_resultado);

        String [] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);


    }

    public void Calcular(View view){
        String valor1_String = edt1.getText().toString();
        String valor2_String = edt2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        String seleccion = spinner1.getSelectedItem().toString();

        if(seleccion.equals("Sumar")){
            int suma = valor1_int + valor2_int;
            tv1.setText(String.valueOf(suma));
        }else if(seleccion.equals("Restar")){
            int resta = valor1_int - valor2_int;
            tv1.setText(String.valueOf(resta));
        }else if(seleccion.equals("Multiplicar")){
            int multiplicacion = valor1_int * valor2_int;
            tv1.setText(String.valueOf(multiplicacion));
        }else if(seleccion.equals("Dividir")){
            if(valor2_int!=0){
                int division = valor1_int/valor2_int;
                tv1.setText(String.valueOf(division));
            }else {
                Toast.makeText(this, "No es posible dividir por 0", Toast.LENGTH_LONG).show();
            }

        }
        

    }



}