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
import com.example.cardioref_homepage.activities.CardioNewsLetter;
import com.example.cardioref_homepage.data.NewsDataHandler;
import com.example.cardioref_homepage.model.Newsletter;

import java.util.List;

public class AddNews extends AppCompatActivity {
    TextView tv_add_news_id;
    EditText et_add_news_headlines,et_add_news_newsURL,et_add_news_source,et_add_news_imagesUrl,et_add_news_date;
    Button btn_add_news, btn_cancel_add_news;
    List<Newsletter> newsList;
    NewsDataHandler newsDataHandler = new NewsDataHandler(this);
    int newsId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_news);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv_add_news_id = findViewById(R.id.tv_add_news_id);
        et_add_news_headlines = findViewById(R.id.et_add_news_headlines);
        et_add_news_newsURL = findViewById(R.id.et_add_news_newsURL);
        et_add_news_source = findViewById(R.id.et_add_news_news_source);
        et_add_news_imagesUrl = findViewById(R.id.et_add_news_image_url);
        et_add_news_date = findViewById(R.id.et_add_news_news_date);
        btn_add_news = findViewById(R.id.btn_add_news_add);
        btn_cancel_add_news = findViewById(R.id.btn_add_news_cancel);

        Intent intent = getIntent();
        newsId = intent.getIntExtra("id",-1);

        newsList = newsDataHandler.getAllNews();

        Newsletter newsletter =  null;
        if(newsId >= 0){
            for (Newsletter n: newsList){
                if (n.getId() == newsId) {
                    newsletter = n;
                }
            }
            tv_add_news_id.setText(String.valueOf(newsId));
            et_add_news_headlines.setText(newsletter.getNewsHeadline());
            et_add_news_newsURL.setText(newsletter.getNewsURL());
            et_add_news_source.setText(newsletter.getSourceName());
            et_add_news_imagesUrl.setText(newsletter.getImageURL());
            et_add_news_date.setText(newsletter.getDatePosted());
        }

        btn_add_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newsId >= 0){
                    Newsletter updateNews = new Newsletter(newsId,et_add_news_headlines.getText().toString(),et_add_news_newsURL.getText().toString(),
                            et_add_news_date.getText().toString(),et_add_news_source.getText().toString(),et_add_news_imagesUrl.getText().toString());
                    newsDataHandler.updateNews(updateNews);

                }else {
                    Newsletter addNewsLetter = new Newsletter(newsId,et_add_news_headlines.getText().toString(),et_add_news_newsURL.getText().toString(),
                            et_add_news_date.getText().toString(),et_add_news_source.getText().toString(),et_add_news_imagesUrl.getText().toString());
                    newsDataHandler.addNews(addNewsLetter);
                }


                Intent returnToNewsletter = new Intent(AddNews.this, CardioNewsLetter.class);
                startActivity(returnToNewsletter);
            }
        });

        btn_cancel_add_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnToNewsletter = new Intent(AddNews.this, CardioNewsLetter.class);
                startActivity(returnToNewsletter);
            }
        });


    }
    //https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-M8InLXk8wX9Cs-cSkOySBFOU2v2QFeuSbQ&s
}
