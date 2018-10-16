package com.example.prince.cakeassignment;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CakeRepository {

    private CakeInterface cakeAPI;

    public CakeRepository(){
        System.out.println("well oh boy");
        cakeAPI = new Retrofit.Builder()
                .baseUrl(CakeInterface.BASE_URL)
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(CakeInterface.class);
    }

    private static class SingletonHelper
    {
        private static final CakeRepository INSTANCE = new CakeRepository();
    }

    public static CakeRepository getInstance()
    {
        return SingletonHelper.INSTANCE;
    }


    public LiveData<List<Cake>> getCakes() {
        final MutableLiveData<List<Cake>> data = new MutableLiveData<>();
        System.out.println("omggggggggggggggggggggggggg");
        cakeAPI.getCakes()
                .enqueue(new Callback<List<Cake>>()
                {
                    @Override
                    public void onResponse(Call<List<Cake>> call, Response<List<Cake>> response)
                    {

                        System.out.println("seriously");
                        data.setValue(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<Cake>> call, Throwable t) {
                        System.out.println("well fuck again");
                        data.setValue(null);
                    }
                });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sooooooooooooo well fuck again");
        return data;
    }
}
