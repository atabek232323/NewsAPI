package com.example.newsapi.data.removte;

import com.example.newsapi.modul.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitServis {
    @GET("v2/everything")//=teslqa&&&=99656d7c382d4660b383a7461d5ba94f
    Call<News> getNews(@Query("q")String tesla ,@Query("from")String data,@Query("sortBy")String sortBy,
                       @Query("apiKey")String apiKey);

@GET("v2/top-headlines")
    Call<News> getNewsbycountry(@Query("country")String country,@Query("category")String category,@Query("apiKey")String apiKey);


   // https://newsapi.org/?=us&=business&apiKey=
}
