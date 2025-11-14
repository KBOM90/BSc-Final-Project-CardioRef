package com.example.cardioref_homepage.model;

import android.provider.ContactsContract;

import androidx.annotation.NonNull;

import java.util.Date;

public class Newsletter {
    private int id;
    private String newsURL;
    private String datePosted;
    private String sourceName;
    private String newsHeadline;
    private String imageURL;


    public Newsletter() {
    }

    public Newsletter(int id, String newsHeadline, String newsURL, String datePosted, String sourceName,String imageURL) {
        this.id = id;
        this.newsHeadline = newsHeadline;
        this.newsURL = newsURL;
        this.datePosted = datePosted;
        this.sourceName = sourceName;
        this.imageURL = imageURL;
    }

    public String getNewsHeadline() {
        return newsHeadline;
    }

    public void setNewsHeadline(String newsHeadline) {
        this.newsHeadline = newsHeadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsURL() {
        return newsURL;
    }

    public void setNewsURL(String newsURL) {
        this.newsURL = newsURL;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @NonNull
    @Override
    public String toString() {
        return "Newsletter{" +
                "id=" + id +
                ", newsURL='" + newsURL + '\'' +
                ", datePosted='" + datePosted + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", newsHeadline='" + newsHeadline + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
