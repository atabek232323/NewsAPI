package com.example.newsapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapi.R;
import com.example.newsapi.modul.Article;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsVievHolder>{
    List<Article> articles;
    Context context;

    public NewsAdapter(List<Article> list, Context context) {
        this.articles = list;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list,parent,false);

        return new NewsVievHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsVievHolder holder, int position) {
        holder.bind(articles.get(position));


    }
    public void add(List<Article> newList){
        this.articles = newList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class  NewsVievHolder extends RecyclerView.ViewHolder{
        CircleImageView circleImageView;
        TextView textTitleNews,textDEs,textSo,textautor,textHours;

        public NewsVievHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.Img_V);
            textautor = itemView.findViewById(R.id.text_Hoers);
            textSo = itemView.findViewById(R.id.text_source);
            textHours = itemView.findViewById(R.id.text_Hours);
            textTitleNews = itemView.findViewById(R.id.textV_NEWS);
            textDEs = itemView.findViewById(R.id.text_V_CAPS);



        }

        public void bind(Article article) {
            Glide.with(context).load(article.getUrlToImage()).into(circleImageView);
            textautor.setText(article.getAuthor());
            textSo.setText( article.getSource().getId());
           textHours.setText(article.getPublishedAt());
           textTitleNews.setText(article.getTitle());
            textDEs.setText(article.getDescription());


        }
    }
}
