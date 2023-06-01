package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    private String nombres[]={"nombre1", "nombre2"};
    private String edades[]={"apellido1", "apellido2"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView);

        lv1 = (ListView) findViewById(R.id.lv1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_file, nombres);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv1.setText("La edad de " + lv1.getItemAtPosition(position) + " es" + edades[position] + " ");
            }
        });
    }
}