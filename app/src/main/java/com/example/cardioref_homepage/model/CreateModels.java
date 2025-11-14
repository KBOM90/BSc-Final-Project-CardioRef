package com.example.cardioref_homepage.model;

import android.app.Application;

import com.example.cardioref_homepage.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateModels extends Application {
    private static List<Questions> questionsList = new ArrayList<Questions>();
    private  static List<TypesOfCVDs> cvdList = new ArrayList<TypesOfCVDs>();
    private static List<Newsletter> newsList = new ArrayList<Newsletter>();
    private static List<Terminologies> wordList = new ArrayList<Terminologies>();

    public CreateModels() {
        fillQuestionList();
        fillCVDS();
        fillNewsletter();
        fillTerminologies();
    }

    private void fillCVDS() {
        TypesOfCVDs cvd1 = new TypesOfCVDs(0, "Coronary Heart Disease", "CHD");
        TypesOfCVDs cvd2 = new TypesOfCVDs(1, "Cerebrovascular Disease (Stoke)", "CBD");
        TypesOfCVDs cvd3 = new TypesOfCVDs(2, "Peripheral Arterial Disease", "PAD");
        TypesOfCVDs cvd4 = new TypesOfCVDs(3, "Congenital Heart Disease", "CHD");
        TypesOfCVDs cvd5 = new TypesOfCVDs(4, "Deep Vein Thrombosis", "DVT");
        TypesOfCVDs cvd6 = new TypesOfCVDs(5, "Rheumatic Heart Disease", "RHD");

        cvdList.addAll(Arrays.asList(new TypesOfCVDs[]{cvd1,cvd2,cvd3,cvd4,cvd5,cvd6}));

    }
    private void fillNewsletter(){
        Newsletter newsletter1 = new Newsletter(1,"Cardiovascular Drugs","https://www.news-medical.net/health/Cardiovascular-Drugs.aspx","Jan 2, 2022", "News-Medical","https://www.pathkindlabs.com/sites/default/files/styles/large/public/2021-08/100.png");
        Newsletter newsletter2 = new Newsletter(1,"‘Groundbreaking’: scientists develop patch that can repair damaged hearts","https://www.theguardian.com/science/2025/jan/29/scientists-develop-patch-repair-damage-heart-failure","Jan 29, 2025","The Guardian","https://i.guim.co.uk/img/media/da6d2ec21d404712af21d7f65e64c416fdcdb002/0_211_4000_2400/master/4000.jpg?width=620&dpr=2&s=none&crop=none");
        Newsletter newsletter3 = new Newsletter(2,"This article is more than 1 month old Sugary drinks linked to millions of new diabetes and heart disease cases – study","https://www.theguardian.com/global-development/2025/jan/06/global-health-inequalities-sugary-drinks-diabetes-heart-disease-africa-latin-america-influencers","Jan 6, 2025","The Guradian","https://i.guim.co.uk/img/media/1ef02855235598f6dd35327b60dbc76658a63fbf/0_233_3500_2101/master/3500.jpg?width=620&dpr=2&s=none&crop=none");
        newsList.addAll(Arrays.asList(new Newsletter[]{newsletter1,newsletter2,newsletter3}));
    }

    private void fillTerminologies(){
        Terminologies terminologies1 = new Terminologies(0,"Arrhythmia", R.raw.arrhythmia,"Any heart rhythm that falls outside the accepted norms.");
        Terminologies terminologies2 = new Terminologies(1,"Atrial Fibrillation (AF)",R.raw.atrial_fibrillation,"Very fast, a disorganized heart rhythm that starts in the atria.");
        Terminologies terminologies3 = new Terminologies(2,"Bradycardia (Bradyarrhythmia)",R.raw.bradycardia,"A heart rate that is abnormally slow; commonly defined as under 60 beats per minute or a rate that is too slow to physiologically support a person and their activities.");
        Terminologies terminologies4 = new Terminologies(3,"Cardiac Arrest",R.raw.cardiac_arrest," Failure of the heart to pump blood through the body. If left untreated, it is dangerous and life-threatening");
        Terminologies terminologies5 = new Terminologies(4,"Cardiovascular",R.raw.cardiovascular,"The term cardiovascular refers to the heart (cardio) and the blood vessels (vascular). The cardiovascular system includes: Arteries. Arterioles. Capillaries.");
        Terminologies terminologies6 = new Terminologies(5,"Chronic Lead",R.raw.chronic_lead,"A pacemaker or ICD lead that has been implanted in the past");
        Terminologies terminologies7 = new Terminologies(6,"Defibrillation",R.raw.defibrillation,"The Process in which an electronic device sends an electric shock to stop an extremely rapid or irregular heartbeat, and restore the normal heart rhythm.");
        Terminologies terminologies8 = new Terminologies(7,"Dual Chamber Pacemaker",R.raw.dual_chamber_pacemaker," A pacemaker with two leads (one in the atrium and one in the ventricle) to allow pacing and/or sensing in both chambers of the heart to artificially restore the natural contraction sequence of the heart.");
        Terminologies terminologies9 = new Terminologies(8,"Ejection Fraction",R.raw.ejection_fraction,"A measure of the output of the heart with each heartbeat.");
        Terminologies terminologies10 = new Terminologies(9,"Ischemia",R.raw.ischaemia,"Insufficient blood flow to tissue due to blockage in the blood flow through the arteries.");
        wordList.addAll(Arrays.asList(new Terminologies[]{terminologies1,terminologies2,terminologies3,terminologies4,terminologies5,terminologies6,terminologies7,terminologies8,terminologies9,terminologies10}));
    }

    private void fillQuestionList() {
        Questions question0 = new Questions(0,"A heart attack means your heart has stopped working.",false);
        Questions question1 = new Questions(1,"Approximately one woman every minute dies of heart disease",true);
        Questions question2 = new Questions(2,"Heart disease doesn’t run in my family, so I am at less risk.",true);
        Questions question3 = new Questions(3,"Nearly half of Americans have at least one risk factor for heart disease.",true);
        Questions question4 = new Questions(4,"Heart disease impacts men more than women.",true);
        Questions question5 = new Questions(5,"Women under the age of 50 are twice as likely to die of a heart attack as men of the same age.",true);
        Questions question6 = new Questions(6,"I’m fine because I don’t have any symptoms.",false);
        Questions question7 = new Questions(7,"Half of the people who have a heart attack die from it.",false);
        Questions question8 = new Questions(8,"Heart disease is a non-communicable disease",true);
        Questions question9 = new Questions(9,"The heart is a muscle.",true);
        Questions question10 = new Questions(10,"Many diseases and conditions can contribute to the risk of heart diseases.",true);
        Questions question11 = new Questions(11,"A heart attack always begins with sharp chest pains",true);
        Questions question12 = new Questions(12,"The best thing to do if you experience heart attack symptoms is to call 911 right away",true);
        Questions question13 = new Questions(13,"Women needs to worry more about breast cancer than about heart diseases",false);
        Questions question14 = new Questions(14,"Quitting smoking is one of the best things you can do for your heart",true);
        Questions question15 = new Questions(15,"If you have a family history of heart disease, you have the same risk yourself",false);
        Questions question16 = new Questions(16,"Air pollution harms the heart",true);
        Questions question17 = new Questions(17,"As we grow old, it is best to rest our heart as much as possible",false);
        Questions question18 = new Questions(18,"Even a person who has experienced a heart attack should exercise",true);
        Questions question19 = new Questions(19,"It is a possible to eat “heart small” diet even if you dine out often",true);
        Questions question20 = new Questions(20,"Emotional stress and anxiety can worsen a heart condition",true);

        questionsList.addAll(Arrays.asList(new Questions[]{question0,question1,question2,question3,question4,question5,question6,question7,question8,question9,question10,
        question11,question12,question13,question14,question15,question16,question17,question18,question19,question20}));
    }



    public static List<Questions> getQuestionsList() {
        return questionsList;
    }


    public static void setQuestionsList(List<Questions> questionsList) {
        CreateModels.questionsList = questionsList;
    }

    public static List<TypesOfCVDs> getCvdList() {
        return cvdList;
    }

    public static void setCvdList(List<TypesOfCVDs> cvdList) {
        CreateModels.cvdList = cvdList;
    }

    public static List<Newsletter> getNewsList() {
        return newsList;
    }

    public static void setNewsList(List<Newsletter> newsList) {
        CreateModels.newsList = newsList;
    }

    public static List<Terminologies> getWordList() {
        return wordList;
    }

    public static void setWordList(List<Terminologies> wordList) {
        CreateModels.wordList = wordList;
    }
}
