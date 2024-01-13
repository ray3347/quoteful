package com.example.quoteful.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quoteful.models.Quote;
import com.example.quoteful.services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> generatedQuote;
    private final MutableLiveData<String> quoteAuthorOnCategory;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        generatedQuote = new MutableLiveData<>();
        quoteAuthorOnCategory = new MutableLiveData<>();
        mText.setValue("Categories");
    }

    public Quote getCategorizedQuote(String category){
        Quote getQuote = new Quote("", "", "");
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.api-ninjas.com/v1/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiService service = retrofit.create(ApiService.class);
        Call<List<Quote>> callApi = service.getQuoteCategorized(category);

        callApi.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(response.isSuccessful()){
                    Object[] quotes = response.body().toArray();
                    // Quote newQuote = new Quote("", "", "");
                    Quote temp = (Quote) quotes[0];
                    generatedQuote.setValue(temp.getQuote());
                    quoteAuthorOnCategory.setValue(temp.getAuthor() + " on " + temp.getCategory());
                    getQuote.setQuote(temp.getQuote());
                    getQuote.setAuthor(temp.getAuthor());
                    getQuote.setCategory(temp.getCategory());
                    Log.d("API SUCCESS", "onResponse: PPPP");
                }
                else{
                    Log.d("FAIL API", "onResponse:" + response);
                }
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.d("FAIL API", "onFailure:" + t);
            }
        });

        return getQuote;
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getQuote() {return generatedQuote;}
    public LiveData<String> getExtra() {return quoteAuthorOnCategory;}
}