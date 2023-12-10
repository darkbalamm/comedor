package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.comedor_uacm.db.DbHelper;

public class menu_gestion_encargado extends AppCompatActivity {

    Button btnmenu,btnPlatillo,btnh,btni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gestion_encargado);
        btnmenu=findViewById(R.id.btn_menu);
        btnPlatillo=findViewById(R.id.btn_platillo);
        btnh=findViewById(R.id.btn_horario);
        btni=findViewById(R.id.btn_ingrediente);
        Toast.makeText(menu_gestion_encargado.this,"ahi vamos 1",Toast.LENGTH_LONG).show();

       /* btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbHelper dbHelper=new DbHelper(menu_gestion_encargado.this);
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                Toast.makeText(menu_gestion_encargado.this,"ahi vamos 2",Toast.LENGTH_LONG).show();
                if(db != null){
                    Toast.makeText(menu_gestion_encargado.this ,"base de datos creada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(menu_gestion_encargado.this ,"algo a salido mal", Toast.LENGTH_LONG).show();
                }
            }
        });*/
        btnPlatillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(menu_gestion_encargado.this,Crud_platillo.class);
                startActivity(i);
            }
        });
        btnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(menu_gestion_encargado.this,Crud_horario.class);
                startActivity(i);
            }
        });
        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(menu_gestion_encargado.this, Crud_ingrediente.class);
                startActivity(i);
            }
        });
    }
}