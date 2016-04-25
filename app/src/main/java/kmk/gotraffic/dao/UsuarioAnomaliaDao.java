package kmk.gotraffic.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Victor on 21/03/2016.
 */
public class UsuarioAnomaliaDao extends OpenSqliteHelper {

    public static final String TABLE_NAME = "usuario_anomalia";
    public static final String COLUMN_NAME_USUARIO_ID = "usuario_id";
    public static final String COLUMN_NAME_ANOMALIA_ID = "anomalia_id";
    public static final String COLUMN_NAME_AVALIACAO = "avaliacao";
    public static final String COLUMN_NAME_DTA_AVALIACAO = "dta_avaliacao";

    public static final String SQL_CREATE_USUARIO_ANOMALIA =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + "FOREIGN KEY (" + COLUMN_NAME_USUARIO_ID + ") "
                    + "REFERENCES usuario (_id), "
                    + "FOREIGN KEY (" + COLUMN_NAME_ANOMALIA_ID + ") "
                    + "REFERENCES anomalia (_id), "
                    + COLUMN_NAME_AVALIACAO + " integer NOT NULL, "
                    + COLUMN_NAME_DTA_AVALIACAO + " text NOT NULL)";

    private SQLiteDatabase db;

    public UsuarioAnomaliaDao(Context context){
        super(context);
        db = getWritableDatabase();
    }
}
