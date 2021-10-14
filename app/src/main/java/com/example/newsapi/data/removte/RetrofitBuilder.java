package com.example.newsapi.data.removte;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static RetrofitServis servis;

    public static RetrofitServis getServis()

    {
        if (servis == null) {
        servis = buildRetrofit();
    }
    return servis;
}
    private static  RetrofitServis buildRetrofit(){
        return new Retrofit.Builder().baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create()).build().create(RetrofitServis.class);
    }//v2/everything?domains=wsj.com&apiKey=99656d7c382d4660b383a7461d5ba94f

}
