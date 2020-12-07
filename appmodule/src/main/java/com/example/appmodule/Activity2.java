package com.example.appmodule;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmodule.adapter.AdapteData;
import com.example.appmodule.databinding.ActivityUiBinding;
import com.example.appmodule.model.DataModel;
import com.example.appmodule.model.UIData;
import com.example.network.Network;
import com.example.network.Networking;
import com.example.network.model.ResponseData;
import com.example.network.model.Uidatum;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private ActivityUiBinding binding;
    private AdapteData adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ui);

        ResponseData data = getIntent().getParcelableExtra("Data");
        if(data !=null){
            setup(data);
        }
        else{
            message("try again");
        }
//        api();
    }

    private void setup(@NotNull ResponseData data) {
        ArrayList<DataModel> models = new ArrayList<>();
        for (Uidatum d:data.getUidata()) {
            DataModel dataModel = new DataModel(d.getKey(), d.getHint(), d.getUitype(), d.getValue());
            models.add(dataModel);
        }

        RecyclerView recyclerView = findViewById(R.id.listView);
        adapter = new AdapteData(this, models);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

//        adapter.setImage(model.getLogoUrl());
    }

    private void message(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    private void api() {
//        binding.progressBar.setVisibility(View.VISIBLE);

        Networking.getInstance().setup(new Network() {
            @Override
            public void fetchCustomUI(ResponseData json, String message) {
            }

            @Override
            public void fetchLogo(Bitmap bitmap, String message) {
                if(bitmap!=null){
                    if (adapter!=null){
                        adapter.setImage(bitmap);
                    }
                }
                else{
                    message(message);
                }
            }
        });
    }
}
