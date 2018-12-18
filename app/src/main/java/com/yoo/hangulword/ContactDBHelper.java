package com.yoo.hangulword;

import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

//import android.database.sqlite.SQLiteOpenHelper;

public class ContactDBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1 ;
    public static final String DBFILE_CONTACT = "contact.db" ;

    public ContactDBHelper(Context context) {

        super(context, DBFILE_CONTACT, null, DB_VERSION);

        Log.d("디비","디비생성확인1");
    }
    public void onCreate(SQLiteDatabase db) {
        Log.d("디비","디비생성확인2");
//        db.execSQL(ContactDBCtrct.SQL_CREATE_TBL) ;
        db.execSQL(ContactDBCtrct.SQL_CREATE_TBL) ;

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // db.execSQL(ContactDBCtrct.SQL_DROP_TBL) ;
        onCreate(db) ;
    }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
        { // onUpgrade(db, oldVersion, newVersion);
        }


}

