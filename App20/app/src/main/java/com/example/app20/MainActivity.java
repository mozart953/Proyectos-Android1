package com.example.app20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv1;
    private Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = (ImageView) findViewById(R.id.imageView2);
        boton1 = (Button) findViewById(R.id.button4);
    }

    public void Ocultar(View view){
        boton1.setVisibility(View.INVISIBLE);
        iv1.setVisibility(View.VISIBLE);

    }
}