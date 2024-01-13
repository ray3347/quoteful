package com.example.quoteful.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quoteful.Quoteful;
import com.example.quoteful.models.Quote;

import java.util.List;

public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private LiveData<List<Quote>> itemList;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
        itemList = Quoteful.db.quoteTransactions().getAllSavedQuotesLive();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Quote>> getItemList() {
        return itemList;
    }
}