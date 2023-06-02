package com.example.app11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView textv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textv1 = (TextView) findViewById(R.id.tv1);

        String dato = getIntent().getStringExtra("nombre");
        textv1.setText("Hola: "+dato);

    }

    public void Regresar (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}