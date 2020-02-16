package com.floykid.catsapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.floykid.catsapp.models.BreedTitle;
import com.floykid.catsapp.repositories.BreedTitlesRepository;

import java.util.List;

public class BreedTitlesViewModel extends ViewModel {

    private MutableLiveData<List<BreedTitle>> mBreedTitles;

    public void init() {
        if (mBreedTitles != null) {
            return;
        }

        BreedTitlesRepository mRepository = BreedTitlesRepository.getInstance();
        mBreedTitles = mRepository.getBreedTitles();
    }

    public LiveData<List<BreedTitle>> getBreedTitles() {
        return mBreedTitles;
    }
}
