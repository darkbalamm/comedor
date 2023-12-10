package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.comedor_uacm.db.plantelDAO;

public class Crud_plantel extends AppCompatActivity {

    EditText etNP;
    EditText etDes;
    Button Gpl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_plantel);

        etNP=findViewById(R.id.NombrePlantel);
        etDes=findViewById(R.id.DescPlantel);
        Gpl=findViewById(R.id.btn_guardarPlantel);

        Gpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantelDAO db=new plantelDAO(Crud_plantel.this);
                long id=db.insertarPlantel(etNP.getText().toString(),etDes.getText().toString());
                if(id >0){
                    Toast.makeText(Crud_plantel.this,"se guardo con exito",Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(Crud_plantel.this,"a ocurrido un error",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    private void limpiar(){
        etNP.setText("");
        etDes.setText("");
    }
}