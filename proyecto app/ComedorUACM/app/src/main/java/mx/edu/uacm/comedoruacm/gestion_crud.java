package mx.edu.uacm.comedoruacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gestion_crud extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_crud);

    }
    public void platillo(View view){
        Intent platillos=new Intent(this,platillo.class);
        startActivity(platillos);
    }
    public void horario(View view){
        Intent horarios=new Intent(this,horario.class);
        startActivity(horarios);
    }
    public void ingrediente(View view){
        Intent ingrediente=new Intent(this,ingrediente.class);
        startActivity(ingrediente);
    }
    public void g_menu(View view){
        Intent menu=new Intent(this,g_menu.class);
        startActivity(menu);
    }
}