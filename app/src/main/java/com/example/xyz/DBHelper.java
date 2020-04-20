package com.example.xyz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String NAMA_DATABASE = "MyDB.db";
    public static final String NAMA_TABEL = "product";
    private static final Integer VERSI_DB = 7 ;

    public static final String PRODUCT_ID = "product_id";
    public static final String PRODUCT_NAME = "product_name";
    public static final String PRODUCT_DESCRIPTION = "product_description";
    public static final String PRODUCT_QUANTITY = "product_quantity";

    public DBHelper(@Nullable Context context) {
        super(context,NAMA_DATABASE, null,VERSI_DB);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + NAMA_TABEL + " (" +
                PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                PRODUCT_NAME + " TEXT, "+
                PRODUCT_DESCRIPTION + " TEXT, "+
                PRODUCT_QUANTITY + " TEXT"+
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+NAMA_TABEL;
        db.execSQL(query);
        onCreate(db);
    }

    public void insertData(String productname,String productdescription,String productquantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRODUCT_NAME,productname);
        values.put(PRODUCT_DESCRIPTION,productdescription);
        values.put(PRODUCT_QUANTITY,productquantity);

        db.insert(NAMA_TABEL,null,values);
        db.close();

    }

}


