package com.example.xyz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Vector;

public class Data {

    DBHelper helper;
    Context context;
    Vector<DataProduct> dataProducts = new Vector<>();
    String id,name,description,quantity;
    DataProduct dataProduct;

    public Data(Context context) {
      this.context = context;
      helper = new DBHelper(context);
    }

    public void insertData(String productname,String productdescription,String productquantity){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(helper.PRODUCT_NAME,productname);
        values.put(helper.PRODUCT_DESCRIPTION,productdescription);
        values.put(helper.PRODUCT_QUANTITY,productquantity);

        db.insert(helper.NAMA_TABEL,null,values);
        db.close();
        storage();
    }

    public void storage(){
        Vector<DataProduct> storage = dataProducts;
        dataProducts.removeAll(storage);
        SQLiteDatabase sqLiteDatabase = helper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery( "SELECT * FROM " + helper.NAMA_TABEL,null);
        cursor.moveToFirst();
        while (cursor.moveToNext()){
            id = cursor.getString(cursor.getColumnIndex(helper.PRODUCT_ID));
            name = cursor.getString(cursor.getColumnIndex(helper.PRODUCT_NAME));
            description = cursor.getString(cursor.getColumnIndex(helper.PRODUCT_DESCRIPTION));
            quantity = cursor.getString(cursor.getColumnIndex(helper.PRODUCT_QUANTITY));
            dataProduct = new DataProduct(name,description,quantity);
            dataProducts.add(dataProduct);
        }

    }
}
