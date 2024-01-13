package com.example.quoteful.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.quoteful.Quoteful;

@Entity
public class Quote {
    @PrimaryKey
    public int uid;
    @ColumnInfo(name= "quote")
    private String quote;
    @ColumnInfo(name= "author")
    private String author;
    @ColumnInfo(name= "category")
    private String category;

    public Quote(String quote, String author, String category) {
        this.quote = quote;
        this.author = author;
        this.category = category;
    }
    public int generateRandomNumber(){
        int maxIntRange = 10000;
        int minIntRange = 1;
        boolean isExists = true;
        int res = 0;

        while(isExists){
            int randomIntInRange = (int) (Math.random() * (maxIntRange - minIntRange + 1)) + minIntRange;
            Quote check = Quoteful.db.quoteTransactions().getQuoteById(randomIntInRange);
            if(check==null){
                res = randomIntInRange;
                isExists = false;
            }
        }
        return  res;
    }
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
