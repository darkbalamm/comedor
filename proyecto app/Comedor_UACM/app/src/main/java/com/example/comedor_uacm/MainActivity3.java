package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerAdapter;
import adapter.RecyclerAdapter1;

public class MainActivity3 extends AppCompatActivity implements RecyclerViewInterface{

    private RecyclerView rvListas;
    private RecyclerAdapter1 adapter;
    private List<ItemPlatillo> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initViews();
        initValues();
    }
        private void initValues() {
            LinearLayoutManager manager = new LinearLayoutManager(this);
            rvListas.setLayoutManager(manager);
            item = getItems();
            adapter = new RecyclerAdapter1(item,this);
            rvListas.setAdapter(adapter);
        }
    private void initViews() { rvListas = findViewById(R.id.rvListas); }
        private List<ItemPlatillo> getItems() {
            List<ItemPlatillo> itemLists = new ArrayList<>();
            itemLists.add(new ItemPlatillo("Platillo","Huevos estellados,frijoles,verduras con salsa al gusto", R.drawable.platillo));
            return itemLists;
        }
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
        intent.putExtra("Image1",item.get(position).getImgResource1());
        intent.putExtra("Titulo1",item.get(position).getTitulo1());
        intent.putExtra("Descripcion1",item.get(position).getDescripcion1());
        startActivity(intent);
    }
}
