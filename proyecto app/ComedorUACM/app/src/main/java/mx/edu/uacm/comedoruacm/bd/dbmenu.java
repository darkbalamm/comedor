package mx.edu.uacm.comedoruacm.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.time.LocalDate;

public class dbmenu extends BDHelper{
    Context context;
    public dbmenu(@Nullable Context context) {
        super(context);
    }
    public long insertarMenu(int id_encargado, LocalDate fecha, int id_horario, int id_platillo){
        long id=0;
        try {
            BDHelper dbhelper= new BDHelper(context);
            SQLiteDatabase db=dbhelper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("id_encargado",id_encargado);
            values.put("fecha", String.valueOf(fecha));
            values.put("id_horario",id_horario);
            values.put("id_platillo",id_platillo);
            id=db.insert(TABLE_menu,null,values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
