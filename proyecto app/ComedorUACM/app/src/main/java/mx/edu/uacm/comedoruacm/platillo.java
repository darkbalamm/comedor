package mx.edu.uacm.comedoruacm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.uacm.comedoruacm.bd.dbplatillo;

public class platillo extends AppCompatActivity {
    EditText nombre_platillo;
    Button agregar_platillo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platillo);

        nombre_platillo=findViewById(R.id.editTextText3);
        agregar_platillo=findViewById(R.id.button4);
        agregar_platillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbplatillo dbp= new dbplatillo(platillo.this);
                long id= dbp.insertarPlatillo(nombre_platillo.getText().toString());
                if(id !=0){
                    Toast.makeText(platillo.this, "se ah registrado correctamente", Toast.LENGTH_LONG).show();
                    limpieza();
                }else{
                    Toast.makeText(platillo.this,"ah ocurrido un error",Toast.LENGTH_LONG).show();
                }

            }
            private void limpieza(){
                nombre_platillo.setText("");

            }
        });

    }
}