package kmk.gotraffic.dao;

import android.content.ContentValues;
import android.content.Context;
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


    public TipoAnomaliaDao(Context context){
        super(context);
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
}
