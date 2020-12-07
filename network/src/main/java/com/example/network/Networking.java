package com.example.network;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import com.example.network.model.ResponseData;
import com.example.network.retrofit.GetDataService;
import com.example.network.retrofit.RetrofitClientInstance;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Networking {
    private static Networking networking;
    private Network callback;

    public static Networking getInstance(){
        if(networking == null){
            networking = new Networking();
        }
        return networking;
    }

    public void setup(Network network){
        this.callback = network;
        api();
    }


    private void api() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ResponseData> call = service.getUiData();
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(@NotNull Call<ResponseData> call, @NotNull Response<ResponseData> response) {
                if(response.body()!=null) {
                    String data = response.body().toString();
                    Log.e("Data ss", data);

                    onJson(response.body());

                }
                else{
                    message1("Try again");
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseData> call, @NotNull Throwable t) {
                t.printStackTrace();
                message1("Something went wrong...Please try later!");
            }
        });
    }
/*

    private void api() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<JSONObject> call = service.getUiData();
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(@NotNull Call<JSONObject> call, @NotNull ResponseData<JSONObject> response) {
                if(response.body()!=null) {
                    String data = response.body().toString();
                    Log.e("Data ss", data);
//                        onJson(response.body());
                }
                else{
                    message1("Try again");
                }
            }

            @Override
            public void onFailure(@NotNull Call<JSONObject> call, @NotNull Throwable t) {
                t.printStackTrace();
                message1("Something went wrong...Please try later!");
            }
        });
    }
*/

    private void apiLogo(String url) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ResponseBody> call = service.getLogo(url);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {
                if(response.body()!=null) {
                    InputStream inputStream = response.body().byteStream();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    Bitmap bmp = BitmapFactory.decodeStream(bufferedInputStream);

                    onImage(bmp);
                }
                else{
                    message2("Try again");
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable t) {
                message2("Something went wrong...Please try later!");
            }
        });
    }

    private void message2(String message) {
        callback.fetchLogo(null, message);
    }

    private void message1(String message) {
        callback.fetchCustomUI(null, message);
    }

    private void onJson(ResponseData json) {
        callback.fetchCustomUI(json, null);
        String logo = json.getLogoUrl();
        apiLogo(logo);
    }

    private void onImage(Bitmap data) {
        callback.fetchLogo(data, null);
    }
}
