package com.example.appmodule.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmodule.R;
import com.example.appmodule.model.DataModel;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapteData extends RecyclerView.Adapter<AdapteData.ViewHolder>{

    private List<DataModel> dataList;
    private Context context;
    private Bitmap bit;

    public AdapteData(Context context,List<DataModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public void setImage(Bitmap bit){
        this.bit = bit;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(dataList.get(position).getUitype());
        holder.key.setText(dataList.get(position).getKey());
        holder.value.setText(dataList.get(position).getValue());
        holder.hint.setText(dataList.get(position).getHint());
        holder.image.setImageBitmap(bit);
/*
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(bit)
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.image);
        */
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView id;
        TextView key;
        TextView value;
        TextView hint;


        public ViewHolder(@NonNull View view) {
            super(view);

            image = view.findViewById(R.id.image);
            id = view.findViewById(R.id.uitype);
            key = view.findViewById(R.id.key);
            value = view.findViewById(R.id.value);
            hint = view.findViewById(R.id.hint);
        }
    }
}
