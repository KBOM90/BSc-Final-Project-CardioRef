package com.example.cardioref_homepage.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.cardioref_homepage.model.Newsletter;

import com.example.cardioref_homepage.util.NewsUtil;


import java.util.ArrayList;
import java.util.List;

public class NewsDataHandler extends SQLiteOpenHelper {

    public NewsDataHandler(@Nullable Context context) {
        super(context, NewsUtil.DATABASE_NAME, null, NewsUtil.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = " CREATE TABLE " + NewsUtil.TABLE_NAME + "(" + NewsUtil.NEWS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NewsUtil.NEWS + " TEXT, " + NewsUtil.NEWS_SOURCE + " TEXT, " + NewsUtil.NEWS_URL + " TEXT, " + NewsUtil.NEWS_DATE + " TEXT, " +
                NewsUtil.IMAGE_URL + " TEXT " + ")";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addNews(Newsletter newsletter){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NewsUtil.NEWS,newsletter.getNewsHeadline());
        cv.put(NewsUtil.NEWS_URL,newsletter.getNewsURL());
        cv.put(NewsUtil.NEWS_SOURCE,newsletter.getSourceName());
        cv.put(NewsUtil.NEWS_DATE,newsletter.getDatePosted());
        cv.put(NewsUtil.IMAGE_URL,newsletter.getImageURL());

        long insert = db.insert(NewsUtil.TABLE_NAME, null, cv);

        if(insert == -1){
            return false;
        }else {
            return true;
        }
    }

    public List<Newsletter> getAllNews(){
        List<Newsletter> allWordList = new ArrayList<>();

        String query = "SELECT * FROM " + NewsUtil.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);


        if(cursor.moveToFirst()){
            do{
                Newsletter newsletter = new Newsletter();
                newsletter.setId(cursor.getInt(0));
                newsletter.setNewsHeadline(cursor.getString(1));
                newsletter.setNewsURL(cursor.getString(2));
                newsletter.setSourceName(cursor.getString(3));
                newsletter.setDatePosted(cursor.getString(4));
                newsletter.setImageURL(cursor.getString(5));
                allWordList.add(newsletter);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return allWordList;
    }

    public Newsletter findNews(Newsletter newsletter){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(NewsUtil.TABLE_NAME,
                new String[]{NewsUtil.NEWS , NewsUtil.NEWS_URL, NewsUtil.NEWS_SOURCE,NewsUtil.NEWS_DATE, NewsUtil.IMAGE_URL},
                NewsUtil.NEWS +"=?",new String[]{String.valueOf(newsletter)},
                null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        //Newsletter newsletter1 = new Newsletter();
        newsletter.setId(cursor.getInt(0));
        newsletter.setNewsHeadline(cursor.getString(1));
        newsletter.setNewsURL(cursor.getString(2));
        newsletter.setSourceName(cursor.getString(3));
        newsletter.setDatePosted(cursor.getString(4));
        newsletter.setImageURL(cursor.getString(5));

        return newsletter;
    }

    public void updateNews(Newsletter newsletter){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(NewsUtil.NEWS,newsletter.getNewsHeadline());
        cv.put(NewsUtil.NEWS_URL,newsletter.getNewsURL());
        cv.put(NewsUtil.NEWS_SOURCE,newsletter.getSourceName());
        cv.put(NewsUtil.NEWS_DATE,newsletter.getDatePosted());
        cv.put(NewsUtil.IMAGE_URL,newsletter.getImageURL());

        db.update(NewsUtil.TABLE_NAME, cv, NewsUtil.NEWS_ID + "=?" ,
                new String[]{String.valueOf(newsletter.getId())});
    }

    public boolean deleteNews(Newsletter newsletter){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + NewsUtil.TABLE_NAME + " WHERE " + NewsUtil.NEWS_ID + " = " + newsletter.getId();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
    }
}
