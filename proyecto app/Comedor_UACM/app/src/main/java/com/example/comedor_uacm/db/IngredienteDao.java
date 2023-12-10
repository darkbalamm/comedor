package com.example.comedor_uacm.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.comedor_uacm.entidades.Ingrediente;

import java.util.ArrayList;

public class IngredienteDao extends DbHelper{
    Context context;
    public IngredienteDao(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertarIngrediente(String Nombre){
        long id=0;
        try {
            DbHelper dbHelper=new DbHelper(context);
            SQLiteDatabase db= dbHelper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("Nombre",Nombre);

            id=db.insert(TABLE_INGREDIENTE,null,values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }
    public ArrayList<Ingrediente> leer_ingredientes(){
        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db =dbHelper.getWritableDatabase();
        ArrayList<Ingrediente> lista_ingredientes= new ArrayList<>();
        Ingrediente ingrediente=null;
        Cursor cursoringrediente=null;
        cursoringrediente=db.rawQuery("SELECT * FROM "+ TABLE_INGREDIENTE,null);
        if(cursoringrediente.moveToFirst()){
            do {
                ingrediente=new Ingrediente();
                ingrediente.setId(cursoringrediente.getInt(0));
                ingrediente.setNombre(cursoringrediente.getString(1));
                lista_ingredientes.add(ingrediente);
            }while (cursoringrediente.moveToNext());
        }
        cursoringrediente.close();
        return lista_ingredientes;
    }
    public Ingrediente ver_ingredientes(int id){
        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db =dbHelper.getWritableDatabase();

        Ingrediente ingrediente=null;
        Cursor cursoringrediente=null;
        cursoringrediente=db.rawQuery("SELECT * FROM "+ TABLE_INGREDIENTE +" WHERE id_ingrediente = "+ id +" LIMIT 1",null);
        if(cursoringrediente.moveToFirst()){
            ingrediente=new Ingrediente();
            ingrediente.setId(cursoringrediente.getInt(0));
            ingrediente.setNombre(cursoringrediente.getString(1));
        }
        cursoringrediente.close();
        return ingrediente;
    }
    public boolean EditarIngrediente(int id,String Nombre){
        boolean correcto=false;
        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        try {
            db.execSQL(" UPDATE "+ TABLE_INGREDIENTE + " SET Nombre = '"+ Nombre + "'WHERE id_ingrediente='"+id+"' " );
            correcto=true;
        }catch (Exception ex){
            ex.toString();
            correcto=false;
        }finally {
            db.close();
        }

        return correcto ;
    }

}
