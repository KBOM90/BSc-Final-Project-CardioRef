package com.example.cardioref_homepage.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardioref_homepage.R;
import com.example.cardioref_homepage.adaptors.CvdAdaptor;
import com.example.cardioref_homepage.cvds_activities.CBDs;
import com.example.cardioref_homepage.cvds_activities.CHD2s;
import com.example.cardioref_homepage.cvds_activities.CHDs;
import com.example.cardioref_homepage.cvds_activities.DVTs;
import com.example.cardioref_homepage.cvds_activities.PADs;
import com.example.cardioref_homepage.cvds_activities.RHDs;
import com.example.cardioref_homepage.model.CreateModels;
import com.example.cardioref_homepage.model.TypesOfCVDs;

import java.util.List;

public class CDV_S extends AppCompatActivity implements CvdAdaptor.OnClickListener {
    List<TypesOfCVDs> cvDsList;
    RecyclerView one_cvd;
    private CvdAdaptor adaptor;
    private RecyclerView.LayoutManager layoutManager;
    CreateModels createModels = (CreateModels) this.getApplication();


  //  CardView corona_heart_disease;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cvds);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cvDsList = CreateModels.getCvdList();

        one_cvd = findViewById(R.id.rv_cvd_types);
        one_cvd.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        one_cvd.setLayoutManager(layoutManager);

        adaptor = new CvdAdaptor(this,cvDsList);
        one_cvd.setAdapter(adaptor);

        adaptor.setOnClickListener(CDV_S.this);



    }

    @Override
    public void onClick(int position) {
        if (position == cvDsList.get(0).getId()){
            Intent intent = new Intent(this,CHDs.class);
            startActivity(intent);
        } else if (position == cvDsList.get(1).getId()) {
            Intent intent = new Intent(this, CBDs.class);
            startActivity(intent);
        }else if (position == cvDsList.get(2).getId()) {
            Intent intent = new Intent(this, PADs.class);
            startActivity(intent);
        }else if (position == cvDsList.get(3).getId()) {
            Intent intent = new Intent(this, CHD2s.class);
            startActivity(intent);
        }else if (position == cvDsList.get(4).getId()) {
            Intent intent = new Intent(this, DVTs.class);
            startActivity(intent);
        }else if (position == cvDsList.get(5).getId()) {
            Intent intent = new Intent(this, RHDs.class);
            startActivity(intent);
        }

    }


}