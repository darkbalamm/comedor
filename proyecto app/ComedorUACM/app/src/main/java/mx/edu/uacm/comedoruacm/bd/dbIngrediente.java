package mx.edu.uacm.comedoruacm.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbIngrediente extends BDHelper{
    Context context;
    public dbIngrediente(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertarIngrediente(String nombre_ingrediente){
        long id=0;
        try {
            BDHelper dbhelper= new BDHelper(context);
            SQLiteDatabase db=dbhelper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("nombre_ingrediente",nombre_ingrediente);
            id=db.insert(TABLE_ingrediente,null,values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
