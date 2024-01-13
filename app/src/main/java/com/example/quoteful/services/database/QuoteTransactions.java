package com.example.quoteful.services.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quoteful.models.Quote;

import java.util.List;

@Dao
public interface QuoteTransactions {
    @Query("SELECT * FROM Quote")
    List<Quote> getAllSavedQuotes();

    @Query("SELECT * FROM Quote")
    LiveData<List<Quote>> getAllSavedQuotesLive();

    @Query("SELECT * FROM Quote WHERE uid = :id")
    Quote getQuoteById(int id);

    @Insert
    void saveQuote(Quote quote);

    @Delete
    void deleteQuote(Quote quote);
}
