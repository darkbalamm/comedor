package mx.edu.uacm.comedoruacm.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {
    private static  final int Database_version=3;
    private static  final String Database_name="uacmComedor.db";
    public static final String TABLE_PLANTEL="plantel";
    public static final String TABLE_horario="horario";
    public static final String TABLE_platillo="platillo";
    public static final String TABLE_ingrediente="ingrediente";
    public static final String TABLE_menu="menu";
    public static final String TABLE_platillo_ingrediente="platillo_ingrediente";
    public static final String TABLE_encargado="encargado";

    public BDHelper(@Nullable Context context) {
        super(context, Database_name, null, Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_PLANTEL+"(" +
                "id_plantel INTEGER PRIMARY KEY AUTOINCREMENT,\n " +
                "nombre_plantel TEXT,\n"+
                "descripcion TEXT)");
        db.execSQL("CREATE TABLE "+TABLE_horario+"(" +
                "id_horario INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "nombre_turno TEXT,\n" +
                "h_inicio INTEGER,\n" +
                "m_inicio INTEGER,\n" +
                "h_final INTEGER,\n" +
                "m_final INTEGER)");
        db.execSQL("CREATE TABLE "+TABLE_platillo+"(" +
                "id_platillo INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "nombre_platillo TEXT)");
        db.execSQL("CREATE TABLE "+TABLE_ingrediente+"(" +
                "id_ingrediente INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "nombre_ingrediente TEXT)");
        db.execSQL("CREATE TABLE "+TABLE_menu+"(" +
                "id_menu INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "id_encargado INTEGER,\n" +
                "fecha DATE,\n" +
                "id_horario INTEGER,\n" +
                "id_platillo INTEGER,\n" +
                "FOREIGN KEY (id_encargado) REFERENCES encargado(Numero_empleado),\n" +
                "FOREIGN KEY (id_horario) REFERENCES horario(id_horario),\n" +
                "FOREIGN KEY (id_platillo) REFERENCES platillo(id_platillo))");
        db.execSQL("CREATE TABLE "+TABLE_platillo_ingrediente+"(" +
                "id_pi INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "id_platillo INTEGER,\n" +
                "id_ingrediente INTEGER,\n" +
                "FOREIGN KEY (id_platillo) REFERENCES platillo(id_platillo),\n" +
                "FOREIGN KEY (id_ingrediente) REFERENCES ingrediente(id_ingrediente))");
        db.execSQL("CREATE TABLE "+TABLE_encargado+"(" +
                "Numero_empleado INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "nombre_usuario TEXT,\n" +
                "correo TEXT,\n" +
                "contraseña TEXT,\n" +
                "id_plantel INTEGER,\n" +
                "FOREIGN KEY (id_plantel) REFERENCES plantel(id_plantel))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLE_PLANTEL);
        db.execSQL("DROP TABLE "+ TABLE_horario);
        db.execSQL("DROP TABLE "+ TABLE_platillo);
        db.execSQL("DROP TABLE "+ TABLE_ingrediente);
        db.execSQL("DROP TABLE "+ TABLE_menu);
        db.execSQL("DROP TABLE "+ TABLE_platillo_ingrediente);
        db.execSQL("DROP TABLE "+ TABLE_encargado);
        onCreate(db);
    }
}
