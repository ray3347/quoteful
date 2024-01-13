package com.example.quoteful.services;

import com.example.quoteful.models.Quote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @Headers("x-api-key: ClF0QARtsa0Z8PTsJUg9kA==vrUxaQlbZo5cK6Ew")
    @GET("quotes")
    Call<List<Quote>> getQuote();

    @Headers("x-api-key: ClF0QARtsa0Z8PTsJUg9kA==vrUxaQlbZo5cK6Ew")
    @GET("quotes")
    Call<List<Quote>> getQuoteCategorized(@Query("category") String category);
}
