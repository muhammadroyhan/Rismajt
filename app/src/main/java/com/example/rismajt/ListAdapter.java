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

public class ListAdapter extends ArrayAdapter<Member> {

    public ListAdapter(Context context, ArrayList<Member> memberArrayList){
        super(context,R.layout.list_member,memberArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Member member = getItem(position);
        if ((convertView == null)){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_member,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.profile_image);
        TextView userName = convertView.findViewById(R.id.namaMember);
        TextView angkatan = convertView.findViewById(R.id.angkatan);

        imageView.setImageResource(member.imageId);
        userName.setText(member.nama);
        angkatan.setText(member.angkatan);

        return convertView;
    }
}
