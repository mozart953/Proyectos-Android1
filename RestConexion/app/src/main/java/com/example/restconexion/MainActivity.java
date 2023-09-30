package com.example.restconexion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText txtUser, txtTitle, txtBody;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = findViewById(R.id.txtUser);
        txtTitle = findViewById(R.id.txtUser);
        txtBody = findViewById(R.id.txtBody);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeedWs();
                enviarWs(txtTitle.getText().toString(), txtBody.getText().toString(), txtUser.getText().toString());
            }
        });
    }

    private void LeedWs(){

        String url = "https://jsonplaceholder.typicode.com/posts/1";
        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtUser.setText(jsonObject.getString("userId"));
                    String title = jsonObject.getString("title");
                    txtTitle.setText(title);
                    txtBody.setText(jsonObject.getString("body"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.getMessage());

            }
        });

        Volley.newRequestQueue(this, ).add(postRequest);
    }

    private void enviarWs(String title, String body, String userId){

        String url = "https://jsonplaceholder.typicode.com/posts";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    /*txtUser.setText(jsonObject.getString("userId"));
                    String title = jsonObject.getString("title");
                    txtTitle.setText(title);
                    txtBody.setText(jsonObject.getString("body"));*/
                    Toast.makeText(MainActivity.this, "RESULTADO ="+ response, Toast.LENGTH_LONG ).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.getMessage());

            }
        })
        {
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("title", title);
                params.put("body", body);
                params.put("userId", userId);
                return params;
            }
        };

        Volley.newRequestQueue(this, ).add(postRequest);
    }
}