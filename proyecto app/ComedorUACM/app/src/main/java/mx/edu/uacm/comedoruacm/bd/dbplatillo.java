package mx.edu.uacm.comedoruacm.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbplatillo extends BDHelper{
    Context context;
    public dbplatillo(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertarPlatillo(String nombre_platillo){
        long id=0;
        try {
            BDHelper dbhelper= new BDHelper(context);
            SQLiteDatabase db=dbhelper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("nombre_platillo",nombre_platillo);
            id=db.insert(TABLE_platillo,null,values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
