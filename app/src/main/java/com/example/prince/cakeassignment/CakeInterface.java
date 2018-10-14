package com.example.prince.cakeassignment;

import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

public interface CakeInterface {
    @GET("8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json")
    Observable<List<Cake>> register();
}
