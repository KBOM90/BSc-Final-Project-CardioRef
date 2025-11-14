package com.example.cardioref_homepage.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardioref_homepage.R;
import com.example.cardioref_homepage.data.DictDataHandler;
import com.example.cardioref_homepage.model.CreateModels;
import com.example.cardioref_homepage.model.Terminologies;
import com.example.cardioref_homepage.adaptors.DictionaryAdaptor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CardioDictionary extends AppCompatActivity {
    FloatingActionButton add_button;
    List<Terminologies> wordList;
    RecyclerView word_list;
    SearchView sv_search_dictionary;

    private DictionaryAdaptor adaptor;
  //  private RecyclerView.Adapter mAdaptor;
    private RecyclerView.LayoutManager layoutManager;
    CreateModels createModels = (CreateModels) this.getApplication();
//    DictDataHandler dictDataHandler = new DictDataHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cardio_dictionary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sv_search_dictionary = findViewById(R.id.sv_dictionary_search);
        sv_search_dictionary.clearFocus();
        sv_search_dictionary.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterWords(newText);
                return true;
            }


        });
//        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.home_dictionary);
//        add_button = findViewById(R.id.fab_add);
//        add_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(CardioDictionary.this, AddWord.class);
//                startActivity(intent);
//            }
//        });

//        wordList = dictDataHandler.getAllWords();
        wordList = CreateModels.getWordList();
        Toast.makeText(this, "Total Number of words: "+ wordList.size(), Toast.LENGTH_SHORT).show();
        Log.d("wordlist", "onCreate: "+wordList);

        word_list = findViewById(R.id.rv_wordlist);
        word_list.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        word_list.setLayoutManager(layoutManager);

        adaptor = new DictionaryAdaptor(wordList,this);
        word_list.setAdapter(adaptor);



    }
    private void filterWords(String text) {
        List<Terminologies> filteredTerminologies = new ArrayList<>();
        for (Terminologies terminologies : wordList){
            if(terminologies.getTerminology().toLowerCase().contains(text.toLowerCase())){
                filteredTerminologies.add(terminologies);
            }
        }
        if(wordList.isEmpty()){
            Toast.makeText(CardioDictionary.this, "No data found", Toast.LENGTH_SHORT).show();
        }else {
            adaptor.setFilter(filteredTerminologies);
        }
    }




}