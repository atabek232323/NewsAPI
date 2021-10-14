package com.example.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.newsapi.adapter.NewsAdapter;
import com.example.newsapi.data.removte.RetrofitBuilder;
import com.example.newsapi.modul.Article;
import com.example.newsapi.modul.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    List<Article> list;
    EditText editText,etText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.res_V);
        list = new ArrayList<>();
        newsAdapter = new NewsAdapter(list,this);
        editText.findViewById(R.id.strana);
        etText.findViewById(R.id.turu);
        btn.findViewById(R.id.btnpoisk);
        LoadNewsByCountry();
        loadNews();



    }



    private void LoadNewsByCountry() {

        RetrofitBuilder.getServis().getNewsbycountry("RU","sport","99656d7c382d4660b383a7461d5ba94f").enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                newsAdapter.add(response.body().getArticles());
                recyclerView.setAdapter(newsAdapter);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.d("TAG", "onFailure: "+t.getLocalizedMessage());
            }
        });
    }

    private void loadNews() {
        RetrofitBuilder.getServis().getNews("tesla","2021-09-13","publishedAt","99656d7c382d4660b383a7461d5ba94f").enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                newsAdapter.add(response.body().getArticles());
                recyclerView.setAdapter(newsAdapter);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.d("TAG", "onFailure: "+getLocalClassName());
            }
        });
    }
}