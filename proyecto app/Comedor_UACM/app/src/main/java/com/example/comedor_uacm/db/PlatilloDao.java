package com.example.comedor_uacm.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.comedor_uacm.entidades.Platillos;

import java.util.ArrayList;

public class PlatilloDao extends DbHelper{
    Context context;
    public PlatilloDao(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertarPlatillo(String Nombre){
        long id=0;
        try {
            DbHelper dbHelper=new DbHelper(context);
            SQLiteDatabase db= dbHelper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("Nombre",Nombre);
            id=db.insert(TABLE_PLATILLO,null,values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }
    public ArrayList<Platillos> leer_platillos(){
        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ArrayList<Platillos> listaPlatillos=new ArrayList<>();
        Platillos platillos=null;
        Cursor cursorPlatillo=null;
        cursorPlatillo=db.rawQuery("SELECT * FROM "+ TABLE_PLATILLO ,null);
        if (cursorPlatillo.moveToFirst()){
            do{
                platillos=new Platillos();
                platillos.setId(cursorPlatillo.getInt(0));
                platillos.setNombre(cursorPlatillo.getString(1));
                listaPlatillos.add(platillos);
            }while (cursorPlatillo.moveToNext());
        }
        cursorPlatillo.close();

        return listaPlatillos;
    }
    public Platillos ver_platillos(int id){
        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db= dbHelper.getWritableDatabase();

        Platillos platillos=null;
        Cursor cursorPlatillo=null;

        cursorPlatillo=db.rawQuery("SELECT * FROM "+ TABLE_PLATILLO +" WHERE id_platillo= "+ id +" LIMIT 1 ",null);
        if (cursorPlatillo.moveToFirst()){
            platillos=new Platillos();
            platillos.setId(cursorPlatillo.getInt(0));
            platillos.setNombre(cursorPlatillo.getString(1));
        }
        cursorPlatillo.close();

        return platillos;
    }
    public boolean EditarPlatillo(int id, String Nombre){
        boolean correcto=false;

        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db= dbHelper.getWritableDatabase();

        try {
            db.execSQL(" UPDATE "+ TABLE_PLATILLO + " SET nombre = '"+ Nombre + "'WHERE id_platillo='"+id+"' " );
            correcto=true;
        }catch (Exception ex){
            ex.toString();
            correcto=false;
        }finally{
            db.close();
        }

        return correcto;
    }

}
