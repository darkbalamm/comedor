package mx.edu.uacm.comedoruacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import mx.edu.uacm.comedoruacm.bd.BDHelper;

public class MainActivity2 extends AppCompatActivity {
    Button btncrear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btncrear=findViewById(R.id.button3);

        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BDHelper dbhelper= new BDHelper(MainActivity2.this);
                SQLiteDatabase db =dbhelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(MainActivity2.this,"base de datos creada",Toast.LENGTH_LONG).show();
                    Encargado(v);
                }else{
                    Toast.makeText(MainActivity2.this,"base de datos no ah sido creada",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    //boton de comensal
    public void Comensal(View view){
        Intent Comensal=new Intent(this,MainActivity3.class);
        startActivity(Comensal);
    }
    //botton de encargado de cocina
    public void Encargado(View view){
        Intent encargado=new Intent(MainActivity2.this, gestion_crud.class);
        startActivity(encargado);
    }
}