package com.example.comedor_uacm;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comedor_uacm.db.HorarioDao;
import com.example.comedor_uacm.entidades.Horario;

public class EditarHorario extends AppCompatActivity {

    EditText txtTurno,txtH_i,txtM_i,txtH_f,txtM_f;
    Button guardarhorario;
    Horario horario;
    boolean correcto=false;

    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_horario);
        txtTurno = findViewById(R.id.Nombre_horario);
        txtH_i = findViewById(R.id.Hora_inicial);
        txtM_i = findViewById(R.id.Minuto_inicial);
        txtH_f = findViewById(R.id.Hora_final);
        txtM_f = findViewById(R.id.Minuto_final);
        guardarhorario = findViewById(R.id.Agregar_horario);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("id_horario");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("id_horario");
        }

        HorarioDao dbhorario = new HorarioDao(EditarHorario.this);
        horario = dbhorario.ver_horario(id);
        // Toast.makeText(this, "no pasa dato", Toast.LENGTH_LONG).show();

        if (horario != null) {
            txtTurno.setText(horario.getNombre());
            txtH_i.setText(String.valueOf(horario.getH_i()));
            txtM_i.setText(String.valueOf(horario.getM_i()));
            txtH_f.setText(String.valueOf(horario.getH_f()));
            txtM_f.setText(String.valueOf(horario.getM_f()));


        }
        guardarhorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtTurno.getText().toString().equals("")) {
                    correcto = dbhorario.editartarHorario(id, txtTurno.getText().toString(), Integer.parseInt(txtH_i.getText().toString()), Integer.parseInt(txtM_i.getText().toString()), Integer.parseInt(txtH_f.getText().toString()), Integer.parseInt(txtM_f.getText().toString()));
                    if (correcto) {
                        Toast.makeText(EditarHorario.this, "dato modificado", Toast.LENGTH_LONG).show();
                        verRegistro();
                    } else {
                        Toast.makeText(EditarHorario.this, "lastima no se agrego", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(EditarHorario.this, "no ah llenado los datos", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    private void verRegistro(){
        Intent i=new Intent(EditarHorario.this,VerHorario.class);
        i.putExtra("id_horario",id);
        startActivity(i);
    }

}

