package sdu.kz.learning;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * Created by Aslan on 20.02.2017.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static String DB_PATH;
    public static String DB_NAME;
    public SQLiteDatabase db;
    public final Context context;

    public DBHelper(Context context, String dbName) throws SQLException {
        super(context, dbName, null, 1);
        this.context = context;
        String packageName = context.getPackageName();
        DB_PATH = String.format("//data//data//sdu.kz.learning//databases//", packageName);
        DB_NAME = dbName;
        openDatabase();
    }

    public void createDatabase() {
        boolean dbExist = checkDatabase();
        if (!dbExist) {
            this.getReadableDatabase();
            try {
                copyDatabase();
            } catch (Exception e) {
                Log.e(this.getClass().toString(), "Copying error");
                throw new Error("Error copying database");
            }
        } else {
            Log.i(this.getClass().toString(), "Database already exists");
        }
    }

    private boolean checkDatabase() {
        SQLiteDatabase checkDB = null;
        try {
            String path = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception e) {
            Log.e(this.getClass().toString(), "Error while checking db");
        }

        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }

    private void copyDatabase() throws IOException {
        InputStream externalDBStream = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream localDBStream = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = externalDBStream.read(buffer)) > 0) {
            localDBStream.write(buffer, 0, bytesRead);
        }
        localDBStream.close();
        externalDBStream.close();
    }

    public SQLiteDatabase openDatabase() throws SQLException {
        String path = DB_PATH + DB_NAME;
        if (db == null) {
            createDatabase();
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        }
        return db;
    }

    public synchronized void close() {
        if (db != null) {
            db.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public SQLiteDatabase getDB() {
        return db;
    }
}
