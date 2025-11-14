package com.example.cardioref_homepage.model;

import androidx.annotation.NonNull;

public class Questions {
    private int id;
    private String question;
    private boolean answer;

    public Questions() {
    }

    public Questions(int id, String question, boolean answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @NonNull
    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
