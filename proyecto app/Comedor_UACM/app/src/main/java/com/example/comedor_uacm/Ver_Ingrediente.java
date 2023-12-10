package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.comedor_uacm.db.IngredienteDao;
import com.example.comedor_uacm.entidades.Ingrediente;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Ver_Ingrediente extends AppCompatActivity {
    EditText txtIngrediente;
    Button guardar;
    FloatingActionButton fabI;
    Ingrediente ingrediente;
    int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_ingrediente);
        txtIngrediente=findViewById(R.id.Ingrediente);
        guardar=findViewById(R.id.btn_Agregar_ingrediente);
        fabI=findViewById(R.id.fabEditarIngrediente);

        if(savedInstanceState ==null){
            Bundle extras= getIntent().getExtras();
            if(extras == null){
                id= Integer.parseInt(null);
            }else{
                id=extras.getInt("id_ingrediente");
            }
        }else{
            id=(int) savedInstanceState.getSerializable("id_ingrediente");
        }
        IngredienteDao dbIng=new IngredienteDao(Ver_Ingrediente.this);
        ingrediente=dbIng.ver_ingredientes(id);
        if(ingrediente!=null){
            txtIngrediente.setText(ingrediente.getNombre());
            guardar.setVisibility(View.INVISIBLE);
            txtIngrediente.setInputType(InputType.TYPE_NULL);
        }
        fabI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Ver_Ingrediente.this,EditarIngrediente.class);
                i.putExtra("id_ingrediente",id);
                startActivity(i);
            }
        });





    }
}