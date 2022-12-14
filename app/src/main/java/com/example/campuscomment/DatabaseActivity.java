package com.example.campuscomment;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseActivity extends SQLiteOpenHelper {
    public static final String CREATE_MEAL = "create table meals(" +
            "mid integer primary key autoincrement, " +
            "name varchar(16), " +
            "location varchar(16)) ";
    public static final String CREATE_COMM = "create table mComm(" +
            "mid integer, " +
            "comment integer, " +
            "cid integer)";

    private Context mContext;

    public DatabaseActivity(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_MEAL);
        db.execSQL(CREATE_COMM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists meals");
        db.execSQL("drop table if exists mComm");
        onCreate(db);
    }

}