package com.example.comedor_uacm;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.comedor_uacm.db.IngredienteDao;
import com.example.comedor_uacm.entidades.Ingrediente;

public class EditarIngrediente extends AppCompatActivity {
    EditText txtIngrediente;
    Button guardar;
    boolean correcto=false;
    Ingrediente ingrediente;
    int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_ingrediente);
        txtIngrediente=findViewById(R.id.Ingrediente);
        guardar=findViewById(R.id.btn_Agregar_ingrediente);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
        IngredienteDao dbIng=new IngredienteDao(EditarIngrediente.this);
        ingrediente=dbIng.ver_ingredientes(id);
        if(ingrediente!=null){
            txtIngrediente.setText(ingrediente.getNombre());
        }
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtIngrediente.getText().toString().equals("")){
                    correcto=dbIng.EditarIngrediente(id,txtIngrediente.getText().toString());
                    if(correcto){
                        Toast.makeText(EditarIngrediente.this, "se realizo el cambio correctamente", Toast.LENGTH_LONG).show();
                        verRegistro();
                    }else{
                        Toast.makeText(EditarIngrediente.this, "Algo fallo en tu cambio", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(EditarIngrediente.this, "llena el campo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void verRegistro(){
        Intent i= new Intent(EditarIngrediente.this,Ver_Ingrediente.class);
        i.putExtra("id_ingrediente",id);
        startActivity(i);
    }
/*
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}