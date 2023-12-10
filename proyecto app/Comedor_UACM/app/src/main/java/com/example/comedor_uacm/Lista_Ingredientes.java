package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.comedor_uacm.db.IngredienteDao;
import com.example.comedor_uacm.entidades.Ingrediente;

import java.util.ArrayList;

import adapter.listaIngredienteAdapter;

public class Lista_Ingredientes extends AppCompatActivity {
    RecyclerView listaIngredientes;
    ArrayList<Ingrediente> listaArrayIngrediente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ingredientes);
        listaIngredientes=findViewById(R.id.id_lista_ingrediente);
        listaIngredientes.setLayoutManager(new LinearLayoutManager(this));

        IngredienteDao dbIngre=new IngredienteDao(Lista_Ingredientes.this);
        listaArrayIngrediente=new ArrayList<>();
        listaIngredienteAdapter adapter=new listaIngredienteAdapter(dbIngre.leer_ingredientes());
        listaIngredientes.setAdapter(adapter);

    }
}