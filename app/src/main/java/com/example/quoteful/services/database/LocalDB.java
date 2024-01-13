package com.example.quoteful.services.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.quoteful.models.Quote;

@Database(entities = {Quote.class}, version = 1)
public abstract class LocalDB extends RoomDatabase {
    public abstract QuoteTransactions quoteTransactions();
}
