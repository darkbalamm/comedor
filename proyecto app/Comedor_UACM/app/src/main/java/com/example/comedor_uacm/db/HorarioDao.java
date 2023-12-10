package com.example.comedor_uacm.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.comedor_uacm.entidades.Horario;

import java.util.ArrayList;

public class HorarioDao extends DbHelper{
    Context context;
    public HorarioDao(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertarHorario(String Nombre,int h_i,int m_i,int h_f,int m_f){
        long id=0;
        try {
            DbHelper dbHelper=new DbHelper(context);
            SQLiteDatabase db= dbHelper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("Nombre",Nombre);
            values.put("HORA_INICIAL",h_i);
            values.put("Minuto_inicial",m_i);
            values.put("HORA_FINAL",h_f);
            values.put("Minuto_FInal",m_f);

            id=db.insert(TABLE_HORARIO,null,values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }
    public ArrayList<Horario> leer_horarios(){
        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Horario> lista_horarios= new ArrayList<>();
        Horario horario=null;
        Cursor cursorhorario= null;
        cursorhorario=db.rawQuery("SELECT * FROM "+ TABLE_HORARIO ,null);
        if(cursorhorario.moveToFirst()){
            do{
                horario=new Horario();
                horario.setId(cursorhorario.getInt(0));
                horario.setNombre(cursorhorario.getString(1));
                horario.setH_i(cursorhorario.getInt(2));
                horario.setM_i(cursorhorario.getInt(3));
                horario.setH_f(cursorhorario.getInt(4));
                horario.setM_f(cursorhorario.getInt(5));
                lista_horarios.add(horario);
            }while (cursorhorario.moveToNext());
        }
        cursorhorario.close();
        return lista_horarios;
    }
    public Horario ver_horario(int id ){
        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Horario horario=null;
        Cursor cursorhorario;
        cursorhorario=db.rawQuery("SELECT * FROM "+ TABLE_HORARIO +" WHERE id_horario= "+ id +" LIMIT 1 " ,null);
        if(cursorhorario.moveToFirst()){
            horario=new Horario();
            horario.setId(cursorhorario.getInt(0));
            horario.setNombre(cursorhorario.getString(1));
            horario.setH_i(cursorhorario.getInt(2));
            horario.setM_i(cursorhorario.getInt(3));
            horario.setH_f(cursorhorario.getInt(4));
            horario.setM_f(cursorhorario.getInt(5));
        }
        cursorhorario.close();
        return horario;
    }
    public boolean editartarHorario(int id,String Nombre,int h_i,int m_i,int h_f,int m_f){
        boolean correcto=false;
        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db= dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE "+TABLE_HORARIO+" set NOMBRE= '"+Nombre+"',HORA_INICIAL= '"+h_i+"',MINUTO_INICIAL= '"+m_i+"',HORA_FINAL= '"+h_f+"',Minuto_FInal= '"+m_f+"'where id_horario='"+id+"'");
            correcto=true;
        }catch (Exception ex){
            ex.toString();
            correcto=false;
        }finally {
            db.close();
        }
        return correcto;
    }

}
