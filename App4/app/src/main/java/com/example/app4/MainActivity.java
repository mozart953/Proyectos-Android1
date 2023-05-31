package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText val1, val2;
    private TextView resultado;

    private RadioButton rad1, rad2, rad3, rad4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = (EditText) findViewById(R.id.txt_val1);
        val2 = (EditText) findViewById(R.id.txt_val2);

        resultado = (TextView) findViewById(R.id.txt_resultado);
        rad1 = (RadioButton) findViewById(R.id.rd1);
        rad2 = (RadioButton) findViewById(R.id.rd2);
        rad3 = (RadioButton) findViewById(R.id.rd3);
        rad4 = (RadioButton) findViewById(R.id.rd4);

    }

    public void Calcular(View view){
        String valor1_String = val1.getText().toString();
        String valor2_String = val2.getText().toString();

        if(rad1.isChecked()==true){
            int res = Integer.parseInt(valor1_String) + Integer.parseInt(valor2_String);
            resultado.setText(String.valueOf(res));
        }else if(rad2.isChecked() == true){

            int res = Integer.parseInt(valor1_String) - Integer.parseInt(valor2_String);
            resultado.setText(res);

        }else if(rad3.isChecked() == true){
            int res = Integer.parseInt(valor1_String) * Integer.parseInt(valor2_String);
            resultado.setText(res);
        }else if (rad4.isChecked() == true){
            if(Integer.parseInt(valor2_String)==0){
                Toast.makeText(this, "No es posible dividir por 0", Toast.LENGTH_LONG).show();
            }else{
                int res = Integer.parseInt(valor1_String) / Integer.parseInt(valor2_String);
                resultado.setText(res);
            }
        }
    }
}