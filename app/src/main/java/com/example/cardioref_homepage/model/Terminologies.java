package com.example.cardioref_homepage.model;

import androidx.annotation.NonNull;

public class Terminologies {
    private int id;
    private String terminology;
    private int word_audio;
    private String meaning;

    public Terminologies() {
    }

    public Terminologies(int id, String terminology, int word_audio, String meaning) {
        this.id = id;
        this.terminology = terminology;
        this.word_audio = word_audio;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerminology() {
        return terminology;
    }

    public void setTerminology(String terminology) {
        this.terminology = terminology;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public int getWord_audio() {
        return word_audio;
    }

    public void setWord_audio(int word_audio) {
        this.word_audio = word_audio;
    }

    @NonNull
    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", terminology='" + terminology + '\'' +
                ", word_audio='" + word_audio + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
