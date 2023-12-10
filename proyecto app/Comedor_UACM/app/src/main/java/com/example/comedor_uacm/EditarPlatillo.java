package com.example.comedor_uacm;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comedor_uacm.db.PlatilloDao;
import com.example.comedor_uacm.entidades.Platillos;

public class EditarPlatillo extends AppCompatActivity {

    EditText txtPlatillo;
    Button btnGuardar;

    boolean correcto=false;

    Platillos platillo;
    int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uplatillo);

        txtPlatillo=findViewById(R.id.NombrePlatilo);
        btnGuardar=findViewById(R.id.AgregarPlatillo);

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
        PlatilloDao dbplatillo=new PlatilloDao(EditarPlatillo.this);
        platillo=dbplatillo.ver_platillos(id);
        if(platillo!=null){
            txtPlatillo.setText(platillo.getNombre());
        }
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtPlatillo.getText().toString().equals("")){
                   correcto= dbplatillo.EditarPlatillo(id,txtPlatillo.getText().toString());
                   if(correcto){
                       Toast.makeText(EditarPlatillo.this, "Se Edito Correctamente", Toast.LENGTH_LONG).show();
                       ver_registro();
                   }else{
                       Toast.makeText(EditarPlatillo.this, "Nose agrego correctamente", Toast.LENGTH_LONG).show();
                   }

                }else {
                    Toast.makeText(EditarPlatillo.this, "Debe cambiar los  datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void ver_registro(){
        Intent i=new Intent(EditarPlatillo.this, UPlatillo.class);
        i.putExtra("id_platillo",id);
        startActivity(i);
    }
}
