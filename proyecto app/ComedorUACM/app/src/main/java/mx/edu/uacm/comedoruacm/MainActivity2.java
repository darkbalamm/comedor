package mx.edu.uacm.comedoruacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    //boton de comensal
    public void Comensal(View view){
        Intent Comensal=new Intent(this,MainActivity3.class);
        startActivity(Comensal);
    }
    //botton de encargado de cocina
    public void Encargado(View view){
        Intent encargado=new Intent(this, login.class);
        startActivity(encargado);
    }
}