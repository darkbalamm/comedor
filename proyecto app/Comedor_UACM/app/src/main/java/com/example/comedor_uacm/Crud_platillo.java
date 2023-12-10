package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.comedor_uacm.db.PlatilloDao;

public class Crud_platillo extends AppCompatActivity {
    EditText NP;
    Button bp, vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_platillo);
        NP=findViewById(R.id.NombrePlatilo);
        bp=findViewById(R.id.AgregarPlatillo);
        vp=findViewById(R.id.verPlatillos);
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlatilloDao db=new PlatilloDao(Crud_platillo.this);
                long id=db.insertarPlatillo(NP.getText().toString());
                if(id>0){
                    Toast.makeText(Crud_platillo.this, "guardado con exito", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(Crud_platillo.this, "No se guardo con exito", Toast.LENGTH_LONG).show();
                }
            }
        });
        vp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Crud_platillo.this, Lista_platillo.class);
                startActivity(intent);
            }
        });
    }
    private void limpiar(){
        NP.setText("");
    }
}