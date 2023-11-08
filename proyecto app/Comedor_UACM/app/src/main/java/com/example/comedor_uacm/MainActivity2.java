package com.example.comedor_uacm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerAdapter;

public class MainActivity2  extends AppCompatActivity implements RecyclerViewInterface{
    private RecyclerView rvLista;
    private RecyclerAdapter adapter;
    private List<ItemList> items;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();
        initValues();
    }
    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);
        items = getItems();
        adapter = new RecyclerAdapter(items,this);
        rvLista.setAdapter(adapter);
    }
    private void initViews() { rvLista = findViewById(R.id.rvLista); }
        private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Cuautepec","Av. La corona No.320,Col. La Palma,Loma la palma,Alcaldia.Gustavo A. Madero,C.P.07160, CDMX", R.drawable.cuautepec));
        itemLists.add(new ItemList("San Lorenzo Tezonco", "Prol.San Isidro No.151, Col.San Lorenzo Tezonco, Alcandia. Iztapalapa,C.P.09790,CDMX", R.drawable.lorenzo));
        itemLists.add(new ItemList("Del Valle", "San Lorenzo No.290, esquina Roberto Gayol, Col.del Valle Sur, Alcandia. Benito Juarez,C.P.03100,CDMX", R.drawable.valle));
        itemLists.add(new ItemList("Centro Historico", "Fray Servando Teresa de Mier No.92 y 99,Col.Obrera, Alcaldía.Cuauhtémoc,C.P.06080,CDMX", R.drawable.centro));
        itemLists.add(new ItemList("Casa Libertad", "Calzada Ermita Iztapalapa No.4163,Col.Lomas de Zaragoza,Alcaldía Iztapalapa,C.P. 09620,CDMX", R.drawable.casa_libertad));

        return itemLists;
      }
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
        intent.putExtra("Image",items.get(position).getImgResource());
        intent.putExtra("Titulo",items.get(position).getTitulo());
        intent.putExtra("Descripcion",items.get(position).getDescripcion());
        startActivity(intent);
    }
}
