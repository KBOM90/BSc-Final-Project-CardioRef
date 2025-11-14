package com.example.cardioref_homepage.Add;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cardioref_homepage.R;
import com.example.cardioref_homepage.activities.CardioDictionary;
import com.example.cardioref_homepage.data.DictDataHandler;
import com.example.cardioref_homepage.model.Terminologies;

import java.util.List;

public class AddWord extends AppCompatActivity {
    Button add_button, cancel_button;
    EditText et_addWord, et_addSound, et_addMeaning;
    TextView et_addId;
    List<Terminologies> wordList;
    DictDataHandler dictDataHandler = new DictDataHandler(this);
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_word);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        add_button =findViewById(R.id.btn_add_addbutton);
        cancel_button = findViewById(R.id.btn_add_cancelbutton);
        et_addWord = findViewById(R.id.et_add_word);
        et_addSound = findViewById(R.id.et_add_sound);
        et_addMeaning = findViewById(R.id.et_add_meaning);
        et_addId = findViewById(R.id.tv_add_id);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",-1);

        wordList = dictDataHandler.getAllWords();

        Terminologies terminologies = null;
        if(id >= 0){
            for (Terminologies t: wordList){
                if (t.getId() == id) {
                    terminologies = t;
                }
            }
            et_addId.setText(String.valueOf(id));
            et_addWord.setText(terminologies.getTerminology());
            et_addSound.setText(terminologies.getWord_audio());
            et_addMeaning.setText(terminologies.getMeaning());
        }

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id >= 0){
                    Terminologies updateWord = new Terminologies(id,et_addWord.getText().toString(),et_addSound.getId(),et_addMeaning.getText().toString());
                    dictDataHandler.updateWord(updateWord);

                }else {
                    Terminologies terminologies = new Terminologies(id,et_addWord.getText().toString(),et_addSound.getId(),et_addMeaning.getText().toString());
                    dictDataHandler.addWord(terminologies);
                }


                    //wordList.add(terminologies1);



                Intent intent1 = new Intent(AddWord.this, CardioDictionary.class);
                startActivity(intent1);
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(AddWord.this,CardioDictionary.class);
                startActivity(intent1);
            }
        });
    }




}