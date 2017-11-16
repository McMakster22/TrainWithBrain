package dk.now.just.trainwithbrain;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mir on 11/14/2017.
 */

public class DbClass extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABSE_NAME = "FeedReader2.db";



    public DbClass(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ENTRIES ="CREATE TABLE " + DBContractClass.RoutinesEntry.TABLE_NAME +
                "(" +DBContractClass.RoutinesEntry.ID + " INTEGER , " + DBContractClass.RoutinesEntry.DATE +" TEXT PRIMARY KEY, " +
                DBContractClass.RoutinesEntry.NAME + " TEXT NOT NULL );";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {


    }
}
