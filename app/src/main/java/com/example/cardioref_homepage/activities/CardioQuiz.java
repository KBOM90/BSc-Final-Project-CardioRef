package com.example.cardioref_homepage.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cardioref_homepage.R;
import com.example.cardioref_homepage.model.CreateModels;
import com.example.cardioref_homepage.model.Questions;

import java.util.List;

public class CardioQuiz extends AppCompatActivity implements View.OnClickListener {
    private List<Questions> questionsList;
    TextView tv_quiz_questions;
    ImageView iv_prev_button, iv_next_button;
    Button btn_true, btn_false;
    private int currentQuestionIndex = 0;
    CreateModels createQuestions = (CreateModels) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cardio_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv_quiz_questions = findViewById(R.id.tv_quiz_questions);
        iv_next_button = findViewById(R.id.iv_next_button);
        iv_prev_button = findViewById(R.id.iv_back_button);
        btn_false = findViewById(R.id.btn_false);
        btn_true = findViewById(R.id.btn_true);

        iv_prev_button.setOnClickListener(this);
        iv_next_button.setOnClickListener(this);
        btn_true.setOnClickListener(this);
        btn_false.setOnClickListener(this);


        questionsList = CreateModels.getQuestionsList();
        Log.d("QuestionList", "onCreate: "+  questionsList.toString());
        Toast.makeText(this, "number of questions" + questionsList.size(), Toast.LENGTH_SHORT).show();

        tv_quiz_questions.setText(questionsList.get(currentQuestionIndex).getQuestion());


    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_true){
            checkAnswer(true);
            move_to_next_question();
        } else if (id == R.id.btn_false) {
            checkAnswer(false);
            move_to_next_question();
        } else if (id == R.id.iv_next_button) {
            move_to_next_question();
        }else{
            prevQuestion();
        }
    }

    private void move_to_next_question() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questionsList.size();
        updateQuestions();
    }

    private void checkAnswer(boolean ans) {
        boolean isCorrect = questionsList.get(currentQuestionIndex).isAnswer();
        int toastMessage = 0;
        if (ans == isCorrect) {
            shakeAnimationForCorrectAns();
            toastMessage = R.string.correct_ans;
           // updateQuestions();

        } else {
            shakeAnimationForWrongAns();
            toastMessage = R.string.wrong_ans;
           // updateQuestions();
        }
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    private void shakeAnimationForCorrectAns() {
        Animation shake = AnimationUtils.loadAnimation(CardioQuiz.this, R.anim.shake_animation);
        CardView cardView = findViewById(R.id.cv_quiz_questions);
        cardView.setAnimation(shake);

        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                cardView.setCardBackgroundColor(Color.GREEN);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardView.setCardBackgroundColor(Color.WHITE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void shakeAnimationForWrongAns() {
        Animation shake = AnimationUtils.loadAnimation(CardioQuiz.this, R.anim.shake_animation);
        CardView cardView = findViewById(R.id.cv_quiz_questions);
        cardView.setAnimation(shake);

        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                cardView.setCardBackgroundColor(Color.RED);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardView.setCardBackgroundColor(Color.WHITE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void updateQuestions() {
        String question = questionsList.get(currentQuestionIndex).getQuestion();
        tv_quiz_questions.setText(question);
    }


    private void prevQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex = (currentQuestionIndex - 1) % questionsList.size();
            updateQuestions();
        }
    }


}