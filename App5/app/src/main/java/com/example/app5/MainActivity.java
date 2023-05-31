package com.example.app5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edt1, edt2;
    private CheckBox check1, check2;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.txt_valor1);
        edt2 = (EditText) findViewById(R.id.txt_valor2);
        check1 = (CheckBox) findViewById(R.id.chbt1);
        check2 = (CheckBox) findViewById(R.id.chbt2);
        tv1 = (TextView) findViewById(R.id.txt_resultado);
    }

    public void Calcular(View view){
        String valor1_String = edt1.getText().toString();
        String valor2_String = edt2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        String resultado = "";

        if(check1.isChecked()==true){
            int suma = valor1_int + valor2_int;
            resultado = " La suma es: "+ suma +" / ";
        }
        if(check2.isChecked()==true){
            int resta = valor1_int - valor2_int;
            resultado= resultado + " La resta es: "+ resta;
        }
        tv1.setText(resultado);

    }
}