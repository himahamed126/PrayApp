package com.example.prayapp.data.local.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PraysViewModel extends AndroidViewModel {
    private PrayRepository mRepository;
    private LiveData<List<Prays>> mAllPrays;

    public PraysViewModel(@NonNull Application application) {
        super(application);
        mRepository = new PrayRepository(application);
        mAllPrays = mRepository.getAllPrays();
    }

    public void insert(Prays prays) {
        mRepository.insert(prays);
    }

    public void update(Prays prays) {
        mRepository.update(prays);
    }

    public void delete(Prays prays) {
        mRepository.delete(prays);
    }

    public void deleteAllPrays() {
        mRepository.deleteAllPrays();
    }

    public LiveData<List<Prays>> getAllPrays() {
        return mAllPrays;
    }
}

