package com.example.network.retrofit;

import com.example.network.model.ResponseData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface GetDataService {

    @GET("mobileapps/android_assignment")
    Call<ResponseData> getUiData();

    @GET()
    @Streaming
    Call<ResponseBody> getLogo(@Url String url);
}
