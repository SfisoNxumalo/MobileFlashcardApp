package com.example.fsa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FlashcardTable {

    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    public FlashcardTable(Context context)
    {
        dbHelper = new DBHelper(context);
    }

    public void openDB()
    {
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public void closeDB()
    {
        sqLiteDatabase.close();
    }

    public void insertRecord(String FTitle, String FDate, String FDescription)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.strColumn_FTitle, FTitle);
        contentValues.put(DBHelper.strColumn_FDate, FDate);
        contentValues.put(DBHelper.strColumn_FDescription, FDescription);

        sqLiteDatabase.insert(DBHelper.strTable_Name, null, contentValues);
    }

    public Cursor getAllRecords()
    {
        return sqLiteDatabase.rawQuery("SELECT * FROM " + DBHelper.strTable_Name, null);
    }

    public void updateRecord(String FID, String FTitle, String FDate, String FDescription)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.strColumn_FTitle, FTitle);
        contentValues.put(DBHelper.strColumn_FDate, FDate);
        contentValues.put(DBHelper.strColumn_FDescription, FDescription);

        sqLiteDatabase.update(dbHelper.strTable_Name, contentValues, FID + "=" +dbHelper.strColumn_FID, null);
    }

    public void deleteRecord(String strID)
    {
        sqLiteDatabase.delete(dbHelper.strTable_Name, strID + "=" + dbHelper.strColumn_FID, null);
    }
}
