package com.asuper.retrofitpractice;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by super on 2017-12-01.
 */

public interface ApiService {

    @GET("api/class")
    Call<List<Data1>> getAllData();
}
