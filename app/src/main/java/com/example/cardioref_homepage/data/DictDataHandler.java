package com.example.cardioref_homepage.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.cardioref_homepage.model.Terminologies;
import com.example.cardioref_homepage.util.DictUtil;

import java.util.ArrayList;
import java.util.List;

public class DictDataHandler extends SQLiteOpenHelper {
    public DictDataHandler(@Nullable Context context) {
        super(context, DictUtil.DATABASE_NAME, null, DictUtil.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + DictUtil.TABLE_NAME + "(" + DictUtil.WORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DictUtil.WORD + " TEXT, " + DictUtil.WORD_SOUND + " TEXT, " + DictUtil.WORD_MEANING + " TEXT" + ")";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addWord(Terminologies terminologies){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DictUtil.WORD,terminologies.getTerminology());
        cv.put(DictUtil.WORD_SOUND,terminologies.getWord_audio());
        cv.put(DictUtil.WORD_MEANING,terminologies.getMeaning());

        long insert = db.insert(DictUtil.TABLE_NAME, null, cv);

        if(insert == -1){
            return false;
        }else {
            return true;
        }
    }

    public List<Terminologies> getAllWords(){
        List<Terminologies> allWordList = new ArrayList<>();

        String query = "SELECT * FROM " + DictUtil.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                Terminologies terminologies = new Terminologies();
                terminologies.setId(cursor.getInt(0));
                terminologies.setTerminology(cursor.getString(1));
                terminologies.setWord_audio(cursor.getInt(2));
                terminologies.setMeaning(cursor.getString(3));
                allWordList.add(terminologies);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return allWordList;
    }

    public Terminologies findWord(Terminologies terminologies){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DictUtil.TABLE_NAME,
                new String[]{ DictUtil.WORD_ID, DictUtil.WORD, DictUtil.WORD_SOUND,DictUtil.WORD_MEANING},
                DictUtil.WORD +"=?",new String[]{String.valueOf(terminologies)},
                null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

       // Terminologies terminologies1 = new Terminologies();
        terminologies.setId(cursor.getInt(0));
        terminologies.setTerminology(cursor.getString(1));
        terminologies.setWord_audio(cursor.getInt(2));
        terminologies.setMeaning(cursor.getString(3));

        return terminologies;
    }

    public void updateWord(Terminologies terminologies){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DictUtil.WORD,terminologies.getTerminology());
        cv.put(DictUtil.WORD_SOUND,terminologies.getWord_audio());
        cv.put(DictUtil.WORD_MEANING,terminologies.getMeaning());

        db.update(DictUtil.TABLE_NAME, cv, DictUtil.WORD_ID + "=?" ,
                new String[]{String.valueOf(terminologies.getId())});
    }

    public boolean deleteWord(Terminologies terminologies ){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + DictUtil.TABLE_NAME + " WHERE " + DictUtil.WORD_ID + " = " + terminologies.getId();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
    }
}
