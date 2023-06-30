package com.example.fsa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String strDB_Name = "FlashcardDB";
    private static final int intDB_Version = 1;
    public static final String strTable_Name = "FLASHCARDS";
    public static final String strColumn_FID ="FID";
    public static final String strColumn_FTitle = "FTitle";
    public static final String strColumn_FDate = "FDate";
    public static final String strColumn_FDescription = "FDescription";

    String strCreate_TableCMD = "Create table" + " " + strTable_Name
            + "(" + strColumn_FID + " " + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + strColumn_FTitle + " " + "text,"
            + strColumn_FDate + " " + "text,"
            + strColumn_FDescription + " " + "text)";


    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase)
    {
        sqliteDatabase.execSQL(strCreate_TableCMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
    }

    public DBHelper(Context context)
    {
        super(context, strDB_Name, null, intDB_Version);
    }
}