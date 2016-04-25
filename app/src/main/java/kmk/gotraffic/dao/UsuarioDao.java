package kmk.gotraffic.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import kmk.gotraffic.model.Usuario;

/**
 * Created by Victor on 19/03/2016.
 */
public class UsuarioDao extends OpenSqliteHelper {

    public static final String TABLE_NAME = "usuario";
    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_EMAIL = "email";
    public static final String COLUMN_NAME_SENHA = "senha";
    public static final String COLUMN_NAME_EXP = "exp";
    public static final String COLUMN_NAME_LEVEL = "level";

    public static final String SQL_CREATE_USUARIO =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + COLUMN_NAME_ID + " INTEGER PRIMARY KEY autoincrement NOT NULL, "
                    + COLUMN_NAME_EMAIL + " text NOT NULL, "
                    + COLUMN_NAME_SENHA + " text NOT NULL, "
                    + COLUMN_NAME_EXP   + " integer NOT NULL DEFAULT(0), "
                    + COLUMN_NAME_LEVEL + " integer NOT NULL DEFAULT(1))";

    private SQLiteDatabase db;

    public UsuarioDao(Context context){
        super(context);
        db = getWritableDatabase();
    }

    public boolean insertUsuario(Usuario usuario){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME_EMAIL, usuario.getEmail());
        contentValues.put(COLUMN_NAME_SENHA, usuario.getSenha());
        contentValues.put(COLUMN_NAME_EXP, usuario.getExp());
        contentValues.put(COLUMN_NAME_LEVEL, usuario.getLevel());
        return (db.insert(TABLE_NAME, null, contentValues) > 0);
    }
}



