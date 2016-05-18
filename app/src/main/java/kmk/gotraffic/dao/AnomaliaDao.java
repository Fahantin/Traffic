package kmk.gotraffic.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import kmk.gotraffic.model.Anomalia;

/**
 * Created by Victor on 19/03/2016.
 */
public class AnomaliaDao extends OpenSqliteHelper {

    public static final String TABLE_NAME = "anomalia";
    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_DTA_CRIACAO = "dta_criacao";
    public static final String COLUMN_NAME_LAT = "lat";
    public static final String COLUMN_NAME_LNG = "lng";
    public static final String COLUMN_NAME_USUARIO_ID = "usuario_id";
    public static final String COLUMN_NAME_TIPO_ANOMALIA_ID = "tipo_anomalia_id";

    public static final String SQL_CREATE_ANOMALIA =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + COLUMN_NAME_ID + " INTEGER PRIMARY KEY autoincrement NOT NULL, "
                    + COLUMN_NAME_DTA_CRIACAO + " text NOT NULL, "
                    + COLUMN_NAME_LAT + " real NOT NULL, "
                    + COLUMN_NAME_LNG + " real NOT NULL, "
                    + "FOREIGN KEY (" + COLUMN_NAME_USUARIO_ID + ") "
                    + "REFERENCES usuario (_id), "
                    + "FOREIGN KEY (" + COLUMN_NAME_TIPO_ANOMALIA_ID + ") "
                    + "REFERENCES anomalia (_id))";

    private SQLiteDatabase db;

    public AnomaliaDao(Context context) {
        super(context);
        db = getWritableDatabase();
    }

    public boolean insertAnomalia(Anomalia anomalia) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME_DTA_CRIACAO, anomalia.getDataCriacao());
        contentValues.put(COLUMN_NAME_LAT, anomalia.getLat());
        contentValues.put(COLUMN_NAME_LNG, anomalia.getLng());
        contentValues.put(COLUMN_NAME_USUARIO_ID, anomalia.getUsuario().getId());
        contentValues.put(COLUMN_NAME_TIPO_ANOMALIA_ID, anomalia.getTipoAnomalia().getId());
        return (db.insert(TABLE_NAME, null, contentValues) > 0);
    }
}
