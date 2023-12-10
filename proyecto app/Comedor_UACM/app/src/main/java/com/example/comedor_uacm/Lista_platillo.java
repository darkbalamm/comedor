package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.comedor_uacm.db.PlatilloDao;
import com.example.comedor_uacm.entidades.Platillos;

import java.util.ArrayList;

import adapter.listaPlatilloAdapter;

public class Lista_platillo extends AppCompatActivity {
    RecyclerView lista_platilo;
    ArrayList<Platillos> listaArrayPlatillos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_platillo);
        lista_platilo=findViewById(R.id.listaPlatillos);
        lista_platilo.setLayoutManager(new LinearLayoutManager(this));

        PlatilloDao dbPlatillo=new PlatilloDao(Lista_platillo.this);
        listaArrayPlatillos=new ArrayList<>();
        listaPlatilloAdapter adapter= new listaPlatilloAdapter(dbPlatillo.leer_platillos());
        lista_platilo.setAdapter(adapter);


    }
}