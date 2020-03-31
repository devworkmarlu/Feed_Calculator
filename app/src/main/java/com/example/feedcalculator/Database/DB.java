package com.example.feedcalculator.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB extends SQLiteOpenHelper  {
    private static final String TAG = DB.class.getSimpleName();
    public  DB (Context context){
        super(context, "FeedCalculatorDB", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TableRecipe = "CREATE TABLE recipeTable("
                + "id INTEGER PRIMARY KEY,"
                + "header TEXT,"
                + "ingredients TEXT);";
        sqLiteDatabase.execSQL(TableRecipe);

        String TableIngredientData = "CREATE TABLE ingredientData("
                + "id INTEGER PRIMARY KEY,"
                + "stat TEXT,"
                + "number TEXT,"
                + "name TEXT,"
                + "protien TEXT,"
                + "energy TEXT,"
                + "calcium TEXT,"
                + "phosphorus TEXT);";
        sqLiteDatabase.execSQL(TableIngredientData);

    }

    public void InsertUpdateDelete(String query){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(query);
        Log.d(TAG, "Added to DB"+ query);
    }

    public Cursor ingredientsAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM ingredientData WHERE stat ='1' ORDER BY number ASC;";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
