package com.example.cardioref_homepage.cvds_activities;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cardioref_homepage.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PADs extends AppCompatActivity {
    VideoView videoView;
    TextView tv_over_view, tv_signs, tv_causes, tv_diagnosis, tv_management;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pads);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv_over_view = findViewById(R.id.tv_over_view);
        InputStream inputStream = this.getResources().openRawResource(R.raw.pad_overview);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        String strData = "";
        if (inputStream != null) {
            try {
                while ((strData = bufferedReader.readLine()) != null) {
                    stringBuffer.append(strData + "\n");
                }
                tv_over_view.setText(stringBuffer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        videoView = findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(PADs.this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pad_video));

        tv_signs = findViewById(R.id.tv_signs);
        InputStream inputStream1 = this.getResources().openRawResource(R.raw.pad_symptoms);
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream1));
        StringBuffer stringBuffer1 = new StringBuffer();
        String strData1 = "";
        if(inputStream1 != null){
            try {
                while ((strData1 = bufferedReader1.readLine()) != null){
                    stringBuffer1.append(strData1 + "\n");
                }
                tv_signs.setText(stringBuffer1);
            }catch (Exception e){
                e.printStackTrace();
            }


        }

        tv_causes = findViewById(R.id.tv_causes);
        InputStream inputStream2 = this.getResources().openRawResource(R.raw.pad_causes);
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream2));
        StringBuffer stringBuffer2 = new StringBuffer();
        String strData2 = "";
        if(inputStream2 != null){
            try {
                while ((strData2 = bufferedReader2.readLine()) != null){
                    stringBuffer2.append(strData2 + "\n");
                }
                tv_causes.setText(stringBuffer2);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        tv_diagnosis = findViewById(R.id.tv_diagnosis);
        InputStream inputStream3 = this.getResources().openRawResource(R.raw.pad_diagnosis);
        BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(inputStream3));
        StringBuffer stringBuffer3 = new StringBuffer();
        String strData3 = "";
        if(inputStream3 != null){
            try {
                while ((strData3 = bufferedReader3.readLine()) != null){
                    stringBuffer3.append(strData3 + "\n");
                }
                tv_diagnosis.setText(stringBuffer3);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        tv_management = findViewById(R.id.tv_management);
        InputStream inputStream4 = this.getResources().openRawResource(R.raw.pad_managment);
        BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(inputStream4));
        StringBuffer stringBuffer4 = new StringBuffer();
        String strData4 = "";
        if(inputStream4 != null){
            try {
                while ((strData4 = bufferedReader4.readLine()) != null){
                    stringBuffer4.append(strData4 + "\n");
                }
                tv_management.setText(stringBuffer4);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}