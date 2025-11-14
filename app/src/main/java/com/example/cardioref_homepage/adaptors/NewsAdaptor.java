package com.example.cardioref_homepage.adaptors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.cardioref_homepage.R;
import com.example.cardioref_homepage.model.Newsletter;

import java.util.List;

public class NewsAdaptor extends RecyclerView.Adapter<NewsAdaptor.MyViewHolder> {
    List<Newsletter> newsList;
    Context context;

    public NewsAdaptor(List<Newsletter> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.one_line_news_letter,parent,false);
        return new NewsAdaptor.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdaptor.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tv_news_headlines.setText(newsList.get(position).getNewsHeadline());
//        holder.tv_news_headlines.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Url = newsList.get(position).getNewsURL();
//                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(Url));
//                context.startActivity(intent);
//            }
//        });
        holder.tv_news_source.setText(newsList.get(position).getSourceName());
        holder.tv_news_date.setText(newsList.get(position).getDatePosted());
        //Glide.with(this.context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStrUJj2JrbXmj2sv42zzFxLGcJfAz8CuDg5A&s").into(holder.iv_news_image);
       Glide.with(this.context).load(newsList.get(position).getImageURL()).into(holder.iv_news_image);


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Url = newsList.get(position).getNewsURL();
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(Url));
                context.startActivity(intent);
//                Intent intent = new Intent(context, AddNews.class);
//                intent.putExtra("id",newsList.get(position).getId());
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_news_headlines, tv_news_source, tv_news_date;
        ImageView iv_news_image;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_news_date = itemView.findViewById(R.id.tv_news_date);
            tv_news_headlines = itemView.findViewById(R.id.tv_news_headline);
            tv_news_source = itemView.findViewById(R.id.tv_news_source);
            parentLayout = itemView.findViewById(R.id.one_line_news);
            iv_news_image = itemView.findViewById(R.id.iv_add_news_url);
            //itemView.setOnClickListener((View.OnClickListener) this);

        }
    }
}
