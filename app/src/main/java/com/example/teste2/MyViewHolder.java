package com.example.teste2;


import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {


    TextView nameview, nota1view, nota2view, mediaview, statusview;


    public MyViewHolder(@NonNull View itemview) {
        super(itemview);
        nota1view = itemview.findViewById(R.id.tvNota1);
        nameview = itemview.findViewById(R.id.tvName);
        nota2view = itemview.findViewById(R.id.tvNota2);
        mediaview = itemview.findViewById(R.id.tvMedia);
        statusview = itemview.findViewById(R.id.tvStatus);

    }
}


