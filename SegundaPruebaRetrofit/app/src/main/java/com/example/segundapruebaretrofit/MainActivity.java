package com.example.segundapruebaretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.segundapruebaretrofit.Modelo.Model;
import com.example.segundapruebaretrofit.Service.ModeloService;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener todos los productos
        ModeloService service = ModeloService.getService();

        List<Model> modelo = service.getModels();

        for (Model modelo1 : modelo) {
            Log.d("MyApp", modelo1.toString());
        }

        // Crear un producto
        Model model1 = new Model();
        model1.setTitle("titulo xd");
        model1.setBody("hola mundo");

        Model createdProduct = service.getAllModels(model1);

        Log.d("MyApp", createdProduct.toString());

        // Actualizar un producto
        product.setId(createdProduct.getId());
        product.setName("Producto Actualizado");
        product.setPrice(200.0);

        Product updatedProduct = service.updateProduct(product);

        Log.d("MyApp", updatedProduct.toString());

        // Eliminar un producto
        service.deleteProduct(createdProduct.getId());

    }
}