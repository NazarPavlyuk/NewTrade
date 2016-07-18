package com.mybringback.thebasics.trade.premodel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ALLO on 18.07.2016.
 */
public interface DataService {
    @GET("datasets/WIKI/BP.json")
    Call<Main> rowsOrder(
            @Query("rows") String rows, @Query("order") String order);
}
