package com.example.quizzapp.ui.newEntry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewEntryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NewEntryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Add a new entry");
    }

    public LiveData<String> getText() {
        return mText;
    }
}