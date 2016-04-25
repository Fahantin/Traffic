package kmk.gotraffic.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Victor on 19/03/2016.
 */
public abstract class OpenSqliteHelper extends SQLiteOpenHelper {

    public static String DATABASE = "go-traffic.db";
    public static int VERSION = 1;

    public OpenSqliteHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioDao.SQL_CREATE_USUARIO);
        db.execSQL(AnomaliaDao.SQL_CREATE_ANOMALIA);
        db.execSQL(UsuarioAnomaliaDao.SQL_CREATE_USUARIO_ANOMALIA);
        db.execSQL(TipoAnomaliaDao.SQL_CREATE_TIPO_ANOMALIA);
        TipoAnomaliaDao.insertDefaultTipoAnomalia(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
