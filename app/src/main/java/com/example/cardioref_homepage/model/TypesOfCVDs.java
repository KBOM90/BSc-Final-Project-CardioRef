package com.example.cardioref_homepage.model;

import androidx.annotation.NonNull;

public class TypesOfCVDs {
    private int id;
    private String CvdType;
    private String CvdShorthand;

    public TypesOfCVDs() {
    }

    public TypesOfCVDs(int id, String cvdType, String cvdShorthand) {
        this.id = id;
        CvdType = cvdType;
        CvdShorthand = cvdShorthand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCvdType() {
        return CvdType;
    }

    public void setCvdType(String cvdType) {
        CvdType = cvdType;
    }

    public String getCvdShorthand() {
        return CvdShorthand;
    }

    public void setCvdShorthand(String cvdShorthand) {
        CvdShorthand = cvdShorthand;
    }

    @NonNull
    @Override
    public String toString() {
        return "TypesOfCVDs{" +
                "id=" + id +
                ", CvdType='" + CvdType + '\'' +
                ", CvdShorthand='" + CvdShorthand + '\'' +
                '}';
    }
}
