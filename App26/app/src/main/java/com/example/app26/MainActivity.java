package com.example.app26;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //para mostrar y ocultar el menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //para las funciones correspondientes a las opciones

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id==R.id.item1){
            Toast.makeText(this,"Opcion 1", Toast.LENGTH_SHORT).show();

        }else if(id==R.id.item2){
            Toast.makeText(this,"Opcion 2", Toast.LENGTH_SHORT).show();

        }else if(id==R.id.item3){
            Toast.makeText(this,"Opcion 3", Toast.LENGTH_SHORT).show();

        }

        return  super.onOptionsItemSelected(item);
    }
}