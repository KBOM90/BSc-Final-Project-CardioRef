package com.example.cardioref_homepage.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardioref_homepage.R;
import com.example.cardioref_homepage.data.NewsDataHandler;
import com.example.cardioref_homepage.model.CreateModels;
import com.example.cardioref_homepage.model.Newsletter;
import com.example.cardioref_homepage.adaptors.NewsAdaptor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CardioNewsLetter extends AppCompatActivity {

   // FloatingActionButton fbtn_add_news;
    List<Newsletter> newsList;
    RecyclerView one_newLetter;
    private NewsAdaptor adaptor;
    private RecyclerView.LayoutManager layoutManager;
    CreateModels createModels = (CreateModels) this.getApplication();
   // NewsDataHandler newsDataHandler = new NewsDataHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cardio_news_lettter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       // Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.home_newsletter);
//        fbtn_add_news = findViewById(R.id.fbtn_add_news);
//        fbtn_add_news.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent addNewsPage = new Intent(CardioNewsLetter.this, AddNews.class);
//                startActivity(addNewsPage);
//            }
//        });

       // newsList = newsDataHandler.getAllNews();
        newsList = CreateModels.getNewsList();
        Toast.makeText(this, "Total Number of words: "+ newsList.size(), Toast.LENGTH_SHORT).show();
        Log.d("wordlist", "onCreate: "+newsList);

        one_newLetter = findViewById(R.id.rv_add_news);
        one_newLetter.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        one_newLetter.setLayoutManager(layoutManager);

        adaptor = new NewsAdaptor(newsList,this);
        one_newLetter.setAdapter(adaptor);



//        rv_add_news = findViewById(R.id.rv_add_news);
//        rv_add_news.setHasFixedSize(true);
//
//        layoutManager = new LinearLayoutManager(this);
//        rv_add_news.setLayoutManager(layoutManager);
//
//        mAdaptor = new NewsAdaptor(newsList,this);
//        rv_add_news.setAdapter(mAdaptor);

    }
}