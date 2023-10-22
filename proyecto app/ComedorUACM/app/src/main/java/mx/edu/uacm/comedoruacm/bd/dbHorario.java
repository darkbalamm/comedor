package mx.edu.uacm.comedoruacm.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.time.LocalTime;

public class dbHorario extends BDHelper{
    Context context;
    public dbHorario(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertarHorario(String nombre_horario,int h_i,int m_i,int h_f,int m_f){
        long id=0;
        try {
            BDHelper dbhelper= new BDHelper(context);
            SQLiteDatabase db=dbhelper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("nombre_turno",nombre_horario);
            values.put("h_inicio",h_i);
            values.put("m_inicio",m_i);
            values.put("h_final",h_f);
            values.put("m_final",m_f);
            id=db.insert(TABLE_horario,null,values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

}
