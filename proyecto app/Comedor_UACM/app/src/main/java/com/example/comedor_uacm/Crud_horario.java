package com.example.comedor_uacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.comedor_uacm.db.HorarioDao;

public class Crud_horario extends AppCompatActivity {

    EditText etn,ethi,etmi,ethf,etmf;
    Button AH,VH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_horario);
        etn=findViewById(R.id.Nombre_horario);
        ethi=findViewById(R.id.Hora_inicial);
        etmi=findViewById(R.id.Minuto_inicial);
        ethf=findViewById(R.id.Hora_final);
        etmf=findViewById(R.id.Minuto_final);
        AH=findViewById(R.id.Agregar_horario);
        VH=findViewById(R.id.verHorario);
        AH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HorarioDao db=new HorarioDao(Crud_horario.this);
                long id=db.insertarHorario(etn.getText().toString(),Integer.parseInt(ethi.getText().toString()),Integer.parseInt(etmi.getText().toString()),Integer.parseInt(ethf.getText().toString()),Integer.parseInt(etmf.getText().toString()));
                if(id>0){
                    Toast.makeText(Crud_horario.this, "guardado exitoso", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else{
                    Toast.makeText(Crud_horario.this, "algo no salio bien", Toast.LENGTH_SHORT).show();
                }
            }
        });
        VH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crud_horario.this,Lista_Horarios.class);
                startActivity(intent);
            }
        });
    }
    public void limpiar(){
        etn.setText("");
        ethi.setText("");
        etmi.setText("");
        ethf.setText("");
        etmf.setText("");
    }
}