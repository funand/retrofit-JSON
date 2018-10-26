package com.example.prince.cakeassignment;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import java.util.List;

public class CakeViewModel extends AndroidViewModel {

    LiveData<List<Cake>> newsResponseObservable;

    public CakeViewModel(@NonNull Application application)
    {
        super(application);
        newsResponseObservable = CakeRepository.getInstance()
                .getCakes();
    }

    public LiveData<List<Cake>> getNewsResponseObservable()
    {
        return newsResponseObservable;
    }
}
