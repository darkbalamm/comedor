package mx.edu.uacm.comedoruacm.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbencargado extends BDHelper{
    Context context;
    public dbencargado(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertarusuario(int numero_empleado,String nombre_usuario,String correo,String contraseña,int id_plantel){
        long id=0;
        try {
            BDHelper dbhelper= new BDHelper(context);
            SQLiteDatabase db=dbhelper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("numero:empleado",numero_empleado);
            values.put("nombre_usuario",nombre_usuario);
            values.put("correo",correo);
            values.put("contraseña",contraseña);
            values.put("id_plantel",id_plantel);
            id=db.insert(TABLE_encargado,null,values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
