package com.example.appmodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appmodule.databinding.ActivityMainBinding;
import com.example.network.Network;
import com.example.network.Networking;
import com.example.network.model.ResponseData;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.appCompatButton.setOnClickListener(v -> {
            api();
        });
    }

    private void api() {
        binding.progressBar.setVisibility(View.VISIBLE);

        Networking.getInstance().setup(new Network() {
            @Override
            public void fetchCustomUI(ResponseData json, String message) {
                binding.progressBar.setVisibility(View.GONE);
                if(json!=null) {
                    Intent i = new Intent(MainActivity.this, Activity2.class);
                    i.putExtra("Data", json);
                    startActivity(i);
                    finish();
                }
                else{
                    message(message);
                }
            }

            @Override
            public void fetchLogo(Bitmap bitmap, String message) {
                binding.progressBar.setVisibility(View.GONE);
                if(bitmap!=null){

                }
                else{
                    message(message);
                }
            }
        });
    }

    private void message(String message) {
        Toast.makeText(this, message,  Toast.LENGTH_SHORT).show();
    }


}