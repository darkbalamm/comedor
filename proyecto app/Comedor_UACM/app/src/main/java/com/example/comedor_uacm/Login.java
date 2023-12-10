package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button btnIn,btnReg;

    Button btnPR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIn=(Button)findViewById(R.id.button_ingresar);
        btnReg=(Button)findViewById(R.id.btn_registrar);
        btnPR=(Button)findViewById(R.id.btn_programador);
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Login.this, menu_gestion_encargado.class);
                startActivity(i);
            }
        });
        btnReg.setVisibility(View.INVISIBLE);
        btnPR.setVisibility(View.INVISIBLE);
        btnPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Login.this,Gestion_programador.class);
                startActivity(i);
            }
        });
    }
}