package com.example.comedor_uacm.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE="uacmcomedor.db";
    public static final String TABLE_Plantel ="T_PLANTEL";
    public static final String TABLE_HORARIO="T_HORARIO";
    public static final String TABLE_PLATILLO="T_PLATILLO";
    public static final String TABLE_INGREDIENTE="T_INGREDIENTE";
    public static final String TABLE_PLANTELXHORARIOXPLATILLO="T_Plantel_horario_platillo";
    public static final String TABLE_PlatilloXIngrediente="T_Platillo_Ingrediente";


    public DbHelper(@Nullable Context context) {
        super(context,DATABASE_NOMBRE,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_Plantel +"("+
                "id_plantel INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "Nombre TEXT NOT NULL,"+
                "Descripcion TEXT)");
        db.execSQL("CREATE TABLE "+ TABLE_PLATILLO +"("+
                "id_platillo INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "Nombre TEXT NOT NULL)");
        db.execSQL("CREATE TABLE "+ TABLE_HORARIO +"("+
                "id_horario INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "NOMBRE TEXT NOT NULL,"+
                "HORA_INICIAL INTEGER NOT NULL,"+
                "Minuto_inicial integer NOT NULL,"+
                "HORA_FINAL INTEGER NOT NULL,"+
                "Minuto_FInal integer NOT NULL)");
        db.execSQL("CREATE TABLE "+ TABLE_INGREDIENTE +"("+
                "id_ingrediente INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "Nombre TEXT NOT NULL)");
        db.execSQL("CREATE TABLE "+ TABLE_PLANTELXHORARIOXPLATILLO +"("+
                "id_Plantel INTERGER NOT NULL,"+
                "horario INTEGER NOT NULL,"+
                "Dia INTEGER NOT NULL,"+
                "MES INTEGER NOT NULL,"+
                "year INTEGER NOT NULL,"+
                "platillo INTEGER NOT NULL,"+
                "PRIMARY KEY(id_Plantel,horario,platillo,Dia,Mes,year),"+
                "FOREIGN KEY(id_plantel) REFERENCES T_PLANTEL(id_plantel)," +
                "FOREIGN KEY(horario) REFERENCES T_HORARIO(id_horario)," +
                "FOREIGN KEY(platillo) REFERENCES T_PLATILLO(id_platillo))");
        db.execSQL("CREATE TABLE "+ TABLE_PlatilloXIngrediente +"("+
                "id_platillo INTEGER NOT NULL,"+
                "ID_INGREDIENTE INTEGER NOT NULL,"+
                "PRIMARY KEY(id_platillo,ID_INGREDIENTE),"+
                "FOREIGN KEY(id_platillo) REFERENCES T_PLATILLO(id_platillo),"+
                "FOREIGN KEY(ID_INGREDIENTE) REFERENCES T_INGREDIENTE(id_ingrediente))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLE_Plantel);
        db.execSQL("DROP TABLE "+ TABLE_HORARIO);
        db.execSQL("DROP TABLE "+ TABLE_PLATILLO);
        db.execSQL("DROP TABLE "+ TABLE_INGREDIENTE);
        db.execSQL("DROP TABLE "+ TABLE_PLANTELXHORARIOXPLATILLO);
        db.execSQL("DROP TABLE "+ TABLE_PlatilloXIngrediente);
        onCreate(db);


    }
}
