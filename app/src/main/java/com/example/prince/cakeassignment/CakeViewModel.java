package com.example.prince.cakeassignment;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.databinding.ObservableField;

import java.util.List;

public class CakeViewModel extends AndroidViewModel {

    private CakeRepository cakeRepository;
    private LiveData<List<Cake>> cakesLive;

    private static final MutableLiveData MUTABLE_LIVE_DATA = new MutableLiveData();
    {
        MUTABLE_LIVE_DATA.setValue(null);
    }

    public final ObservableField<List<Cake>> project = new ObservableField<>();
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
