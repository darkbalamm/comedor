package mx.edu.uacm.comedoruacm.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbplatillo_ingrediente extends BDHelper{
    Context context;
    public dbplatillo_ingrediente(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertarPlatillo_ingrediente(int id_platillo,int id_ingrediente){
        long id=0;
        try {
            BDHelper dbhelper= new BDHelper(context);
            SQLiteDatabase db=dbhelper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("id_platillo",id_platillo);
            values.put("id_ingrediente",id_ingrediente);
            id=db.insert(TABLE_platillo_ingrediente,null,values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
