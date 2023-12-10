package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.comedor_uacm.db.HorarioDao;
import com.example.comedor_uacm.entidades.Horario;

import java.util.ArrayList;

import adapter.listaHorarioAdapter;

public class Lista_Horarios extends AppCompatActivity {

    RecyclerView lista_horario;

    ArrayList<Horario> listaArrayHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_horarios);
        lista_horario=findViewById(R.id.id_lista_horarios);
        lista_horario.setLayoutManager(new LinearLayoutManager(this));

        HorarioDao dbhorario=new HorarioDao(Lista_Horarios.this);
        listaArrayHorario= new ArrayList<>();
        listaHorarioAdapter  adapter= new listaHorarioAdapter(dbhorario.leer_horarios());
        lista_horario.setAdapter(adapter);
    }
}