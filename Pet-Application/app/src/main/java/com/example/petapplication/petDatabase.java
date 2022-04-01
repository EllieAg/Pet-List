package com.example.petapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class petDatabase extends SQLiteOpenHelper {

    private static final String PET_TABLE = "PET_TABLE";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PET_NAME = "PET_NAME";
    private static final String COLUMN_PET_BREED = "PET_BREED";
    private static final String COLUMN_PET_WEIGHT = "PET_WEIGHT";
    private static final String COLUMN_PET_DESC = "PET_DESC";

    public petDatabase(@Nullable Context context) {
        super(context, "pet.db", null, 1);
    }

    // sqlite code
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + PET_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PET_NAME + " TEXT, " + COLUMN_PET_BREED + " TEXT, " + COLUMN_PET_WEIGHT + " INT, " +
                COLUMN_PET_DESC + " TEXT)";

        db.execSQL(createTable);
    }

    // no need to be use, only when working with different database versions
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // add the pet to the database
    public boolean addOne(Pet pet){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PET_NAME, pet.getPetName());
        cv.put(COLUMN_PET_BREED, pet.getPetBreed());
        cv.put(COLUMN_PET_WEIGHT, pet.getPetWeight());
        cv.put(COLUMN_PET_DESC, pet.getPetDesc());

        long insert = db.insert(PET_TABLE, null, cv);

        if(insert == -1){
            return false;
        }else
            return true;

    }

    public List<Pet> getAllPet(){
        List<Pet> returnList = new ArrayList<>();

        //get data from database
        String queryString = "SELECT * FROM " + PET_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            // loop thru the cursor and add a new object
            do{
                int petID = cursor.getInt(0);
                String petName = cursor.getString(1);
                String petBreed = cursor.getString(2);
                int petWeight = cursor.getInt(3);
                String petDesc = cursor.getString(4);

                Pet newPet = new Pet(petID, petName, petBreed, petWeight, petDesc);
                returnList.add(newPet);

            } while(cursor.moveToNext());
        }
        else{
            // fail empty
        }

        cursor.close();
        db.close();
        return returnList;
    }
}
