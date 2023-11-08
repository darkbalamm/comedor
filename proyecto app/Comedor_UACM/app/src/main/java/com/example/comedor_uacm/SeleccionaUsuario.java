package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SeleccionaUsuario extends AppCompatActivity {
    Button btnC;
    Button btnE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona_usuario);

        btnC=(Button)findViewById(R.id.button_Comenzal);
        btnE=(Button)findViewById((R.id.button_Encargado));
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (SeleccionaUsuario.this, MainActivity2.class);
                startActivity(i);
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (SeleccionaUsuario.this, Login.class);
                startActivity(i);
            }
        });

    }


}