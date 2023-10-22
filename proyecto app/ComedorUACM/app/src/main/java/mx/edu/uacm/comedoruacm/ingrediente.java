package mx.edu.uacm.comedoruacm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.uacm.comedoruacm.bd.dbIngrediente;

public class ingrediente extends AppCompatActivity {
    EditText nuevo_ingrediente;
    Button agregar_ingrediente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingrediente);
        nuevo_ingrediente=findViewById(R.id.editTextText4);
        agregar_ingrediente=findViewById(R.id.button10);
        agregar_ingrediente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbIngrediente dpi=new dbIngrediente(ingrediente.this);
                long id= dpi.insertarIngrediente(nuevo_ingrediente.getText().toString());
                if(id !=0){
                    Toast.makeText(ingrediente.this, "se ah registrado correctamente", Toast.LENGTH_LONG).show();
                    limpieza();
                }else{
                    Toast.makeText(ingrediente.this,"ah ocurrido un error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpieza(){
       nuevo_ingrediente.setText("");
    }
}