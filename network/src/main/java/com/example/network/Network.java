package com.example.network;

import android.graphics.Bitmap;

import com.example.network.model.ResponseData;

public interface Network {
    void fetchCustomUI(ResponseData json, String message);

    void fetchLogo(Bitmap bitmap, String message);
}
