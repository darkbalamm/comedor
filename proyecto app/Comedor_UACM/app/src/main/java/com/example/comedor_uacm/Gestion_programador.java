package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gestion_programador extends AppCompatActivity {

    Button btn_plantel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_programador);
        btn_plantel=findViewById(R.id.btn_g_plantel);
        btn_plantel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Gestion_programador.this,Crud_plantel.class);
                startActivity(intent);


            }
        });

    }
}