package com.example.comedor_uacm.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.comedor_uacm.entidades.Plantel;

import java.util.ArrayList;

public class plantelDAO extends DbHelper{
    Context context;
    public plantelDAO(@Nullable Context context) {
        super(context);
        this.context= context;
    }
    public long insertarPlantel(String Nombre,String Descripcion){
        long id=0;
        try {
            DbHelper dbHelper=new DbHelper(context);
            SQLiteDatabase db= dbHelper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("Nombre",Nombre);
            values.put("Descripcion",Descripcion);

            id=db.insert(TABLE_Plantel,null,values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }
    public ArrayList<Plantel> leer_planteles(){
        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ArrayList<Plantel> Lista_planteles= new ArrayList<>();
        Plantel plantel=null;
        Cursor cursorPlantel=null;
        cursorPlantel=db.rawQuery("SELECT * FROM "+ TABLE_Plantel , null );
        if (cursorPlantel.moveToFirst()){
            do{
                plantel=new Plantel();
                plantel.setId(cursorPlantel.getInt(0));
                plantel.setNombre(cursorPlantel.getString(1));
                plantel.setDescripcion(cursorPlantel.getString(2));
                Lista_planteles.add(plantel);
            }while (cursorPlantel.moveToNext());
        }
        cursorPlantel.close();
        return Lista_planteles;
    }
}
