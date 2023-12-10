package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.comedor_uacm.db.PlatilloDao;
import com.example.comedor_uacm.entidades.Platillos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UPlatillo extends AppCompatActivity {

    EditText txtPlatillo;
    Button btnGuardar;

    Platillos platillo;

    FloatingActionButton fab;
    int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uplatillo);

        txtPlatillo=findViewById(R.id.NombrePlatilo);
        btnGuardar=findViewById(R.id.AgregarPlatillo);
        fab=findViewById(R.id.fabEditarIngrediente);

        if(savedInstanceState ==null){
            Bundle extras= getIntent().getExtras();
            if(extras == null){
                id= Integer.parseInt(null);
            }else{
                id=extras.getInt("id_platillo");
            }
        }else{
           id=(int) savedInstanceState.getSerializable("id_platillo");
        }
        PlatilloDao dbplatillo=new PlatilloDao(UPlatillo.this);
        platillo=dbplatillo.ver_platillos(id);
        if(platillo!=null){
            txtPlatillo.setText(platillo.getNombre());
            btnGuardar.setVisibility(View.INVISIBLE);
            txtPlatillo.setInputType(InputType.TYPE_NULL);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=  new Intent(UPlatillo.this,EditarPlatillo.class);
                i.putExtra("id_platillo",id);
                startActivity(i);
            }
        });
    }
}