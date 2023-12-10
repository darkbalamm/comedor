package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.comedor_uacm.db.IngredienteDao;

public class Crud_ingrediente extends AppCompatActivity {
    EditText etgi;
    Button Gi,VI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_ingrediente);
        etgi=findViewById(R.id.Ingrediente);
        Gi=findViewById(R.id.btn_Agregar_ingrediente);
        VI=findViewById(R.id.btn_ver_ingredientes);
        Gi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngredienteDao db=new IngredienteDao(Crud_ingrediente.this);
                long id=db.insertarIngrediente(etgi.getText().toString());
                if(id>0){
                    Toast.makeText(Crud_ingrediente.this, "se agrego exitosamente", Toast.LENGTH_SHORT).show();
                    Limpiar();
                }else{
                    Toast.makeText(Crud_ingrediente.this, "Hubo un error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        VI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Crud_ingrediente.this,Lista_Ingredientes.class);
                startActivity(i);
            }
        });
    }
    public void Limpiar(){
        etgi.setText("");
    }
}