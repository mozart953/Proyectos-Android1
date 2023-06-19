package com.example.app27;

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

    //metodo para mostrar los botones de accion

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuacciones, menu);
        return true;

    }

    //metodo para agregar las acciones de nuestros botones

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id ==R.id.compartir){
            Toast.makeText(this, "Compartir", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id ==R.id.buscar){
            Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id ==R.id.opcion1){
            Toast.makeText(this, "Opcion 1", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id ==R.id.opcion2){
            Toast.makeText(this, "Opcion 2", Toast.LENGTH_SHORT).show();
            return true;
        }

        return  super.onOptionsItemSelected(item);

    }
}