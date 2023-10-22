package mx.edu.uacm.comedoruacm.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbplantel extends BDHelper{
    Context context;
    public dbplantel(@Nullable Context context) {
        super(context);
        this.context= context;
    }
    public long insertarPlantel(int id_plantel,String nombre_plantel){
        long id=0;
        try {
            BDHelper dbhelper = new BDHelper(context);
            SQLiteDatabase db = dbhelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("id_plantel",id_plantel);
            values.put("nombre_plantel", nombre_plantel);

            id = db.insert(TABLE_PLANTEL, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
