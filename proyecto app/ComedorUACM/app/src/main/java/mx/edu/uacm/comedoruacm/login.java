package mx.edu.uacm.comedoruacm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.uacm.comedoruacm.bd.dbplantel;

public class login extends AppCompatActivity {
    EditText nombre_plantel,id_plantel;
    Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre_plantel=findViewById(R.id.editTextText2);
        id_plantel=findViewById(R.id.editTextText);
        registrar=findViewById(R.id.button6);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbplantel dbp= new dbplantel(login.this);
                long id= dbp.insertarPlantel(Integer.parseInt(id_plantel.getText().toString()),nombre_plantel.getText().toString());
                if(id !=0){
                    Toast.makeText(login.this, "se ah registrado correctamente", Toast.LENGTH_LONG).show();
                    limpieza();
                }else{
                    Toast.makeText(login.this,"ah ocurrido un error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpieza(){
        id_plantel.setText("");
        nombre_plantel.setText("");
    }
}