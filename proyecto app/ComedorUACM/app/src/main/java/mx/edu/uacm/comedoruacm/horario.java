package mx.edu.uacm.comedoruacm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalTime;

import mx.edu.uacm.comedoruacm.bd.BDHelper;
import mx.edu.uacm.comedoruacm.bd.dbHorario;

public class horario extends AppCompatActivity {
    EditText nombre_turno,h_inicial,m_inicial,h_final,m_final;
    Button agregarHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        nombre_turno=findViewById(R.id.editTextText5);
        h_inicial=findViewById(R.id.editTextText6);
        m_inicial=findViewById(R.id.editTextText7);
        h_final=findViewById(R.id.editTextText8);
        m_final=findViewById(R.id.editTextText9);
        agregarHorario=findViewById(R.id.button11);
        agregarHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHorario dbh= new dbHorario(horario.this);
                long id= dbh.insertarHorario(nombre_turno.getText().toString(),Integer.parseInt(h_inicial.getText().toString()),Integer.parseInt(m_inicial.getText().toString()),Integer.parseInt(h_final.getText().toString()),Integer.parseInt(m_final.getText().toString()));
                if(id !=0){
                    Toast.makeText(horario.this, "se ah registrado correctamente", Toast.LENGTH_LONG).show();
                    limpieza();
                }else{
                    Toast.makeText(horario.this,"ah ocurrido un error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpieza(){
        nombre_turno.setText("");
        h_inicial.setText("");
        m_inicial.setText("");
        h_final.setText("");
        m_final.setText("");
    }
}