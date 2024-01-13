package com.example.quoteful.ui.dashboard;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quoteful.models.Quote;
import com.example.quoteful.services.ApiService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardViewModel extends ViewModel {
//    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> selectedQuote;
    private final MutableLiveData<String> selectedAuthor;

    private Quote activeQuote = new Quote("", "", "");
    public DashboardViewModel() {
        selectedQuote = new MutableLiveData<>();
        selectedAuthor = new MutableLiveData<>();
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.api-ninjas.com/v1/").addConverterFactory(GsonConverterFactory.create()).build();
//        ApiService service = retrofit.create(ApiService.class);
//        Call<List<Quote>> callApi = service.getQuote();
//        callApi.enqueue(new Callback<List<Quote>>() {
//            @Override
//            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
//                if(response.isSuccessful()){
//                    Object[] quotes = response.body().toArray();
//                    Quote temp = (Quote) quotes[0];
//                    activeQuote.setQuote(temp.getQuote());
//                    activeQuote.setAuthor(temp.getAuthor());
//                    selectedAuthor.setValue(activeQuote.getAuthor());
//                    selectedQuote.setValue(activeQuote.getQuote());
//                    Log.d("API SUCCESS", "onResponse: PPPP");
//                }
//                else{
//                    Log.d("FAIL API", "onResponse:" + response);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Quote>> call, Throwable t) {
//                Log.d("FAIL API", "onFailure:" + t);
//            }
//        }
        // newQuote();
    }

    public Quote newQuote(){
        Quote getQuote = new Quote("", "", "");
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.api-ninjas.com/v1/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiService service = retrofit.create(ApiService.class);
        Call<List<Quote>> callApi = service.getQuote();
        callApi.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(response.isSuccessful()){
                    Object[] quotes = response.body().toArray();
                    Quote temp = (Quote) quotes[0];
                    activeQuote.setQuote(temp.getQuote());
                    activeQuote.setAuthor(temp.getAuthor());
                    selectedAuthor.setValue(activeQuote.getAuthor());
                    selectedQuote.setValue(activeQuote.getQuote());
                    Log.d("API SUCCESS", "onResponse: success");
                    getQuote.setQuote(temp.getQuote());
                    getQuote.setAuthor(temp.getAuthor());
                    getQuote.setCategory(temp.getCategory());
                }else{
                    Log.d("FAIL API", "onFailure:" + response);
                }
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.d("FAIL API", "onFailure:" + t);
            }
        });

        return getQuote;
    }

    public LiveData<String> getQuote() {
        return selectedQuote;
    }
    public LiveData<String> getAuthor() {
        return selectedAuthor;
    }
}