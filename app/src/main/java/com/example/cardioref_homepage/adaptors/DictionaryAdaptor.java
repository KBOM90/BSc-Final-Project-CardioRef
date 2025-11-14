package com.example.cardioref_homepage.adaptors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cardioref_homepage.Add.AddWord;
import com.example.cardioref_homepage.R;
import com.example.cardioref_homepage.model.Terminologies;

import java.util.List;

public class DictionaryAdaptor extends RecyclerView.Adapter<DictionaryAdaptor.MyViewHolder> {
    List<Terminologies> wordList;
    Context context;

    public DictionaryAdaptor(List<Terminologies> wordList, Context context) {
        this.context = context;
        this.wordList = wordList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.one_line_term_word,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tv_terminology.setText(wordList.get(position).getTerminology());
        Glide.with(context).load("data:image/jpeg;base64,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").into(holder.iv_sound_pic);
        holder.iv_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
//                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//                    mediaPlayer.setDataSource("https://"+wordList.get(position).getWord_audio());
                    MediaPlayer mediaPlayer = MediaPlayer.create(context,wordList.get(position).getWord_audio());
                    //mediaPlayer.prepare();
                    mediaPlayer.start();
                }catch (Exception e){
                    Toast.makeText(context, "Could not play Audio", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.tv_meaning.setText(wordList.get(position).getMeaning());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddWord.class);
                intent.putExtra("id",wordList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setFilter(List<Terminologies> filteredTerminologies) {
        this.wordList = filteredTerminologies;
        notifyDataSetChanged();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_terminology;
        ImageView iv_sound;
        TextView tv_meaning;
        ImageView iv_sound_pic;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_terminology = itemView.findViewById(R.id.tv_teminology);
            iv_sound = itemView.findViewById(R.id.iv_mic);
            tv_meaning = itemView.findViewById(R.id.tv_meaning);
            parentLayout = itemView.findViewById(R.id.one_line_term_word);
            iv_sound_pic = itemView.findViewById(R.id.iv_sound);
        }

    }



}
