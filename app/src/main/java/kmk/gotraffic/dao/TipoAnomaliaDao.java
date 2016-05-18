package kmk.gotraffic.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Victor on 19/03/2016.
 */
public class TipoAnomaliaDao extends OpenSqliteHelper {

    public static final String TABLE_NAME = "tipo_anomalia";
    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_DESCRICAO = "descricao";
    public static final String COLUMN_NAME_ICONE = "icone";

    public static final String SQL_CREATE_TIPO_ANOMALIA =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + COLUMN_NAME_ID + " INTEGER PRIMARY KEY autoincrement NOT NULL, "
                    + COLUMN_NAME_DESCRICAO + " text NOT NULL, "
                    + COLUMN_NAME_ICONE + " text NOT NULL)";


    private SQLiteDatabase db;

    public TipoAnomaliaDao(Context context) {
        super(context);
        db = getWritableDatabase();
    }

    public static void insertDefaultTipoAnomalia(SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME_DESCRICAO, "Buraco");
        contentValues.put(COLUMN_NAME_ICONE, "./img/buraco.jpg");
        db.insert(TABLE_NAME, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME_DESCRICAO, "Congestionamento");
        contentValues.put(COLUMN_NAME_ICONE, "./img/congest.jpg");
        db.insert(TABLE_NAME, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME_DESCRICAO, "Acidente");
        contentValues.put(COLUMN_NAME_ICONE, "./img/acidente.jpg");
        db.insert(TABLE_NAME, null, contentValues);
    }

    public String consulta() {

        String query = "select * from tipo_anomalia";
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            String a = c.getString(c.getColumnIndex("_id"));
            String b = c.getString(c.getColumnIndex("descricao"));
            String d = c.getString(c.getColumnIndex("icone"));

            return "_id: " + a + " - descricao: " + b + " - icone: " + c;
        }
        return "Não Encontrou nada";
    }
}
