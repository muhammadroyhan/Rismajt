package com.example.rismajt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BisnisAdapter extends ArrayAdapter<Bisnis> {

    public BisnisAdapter(Context context, ArrayList<Bisnis> bisnisArrayList){
        super(context,R.layout.list_bisnis,bisnisArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Bisnis bisnis = getItem(position);
        if ((convertView == null)){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_bisnis,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.usahaProfile);
        TextView namab = convertView.findViewById(R.id.namaBisnis);
        TextView bidang = convertView.findViewById(R.id.bidangUsaha);

        imageView.setImageResource(bisnis.imageId);
        namab.setText(bisnis.namab);
        bidang.setText(bisnis.bidang);

        return convertView;
    }
}
