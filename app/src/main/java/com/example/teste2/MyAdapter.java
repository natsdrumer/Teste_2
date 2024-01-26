package com.example.teste2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.teste2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    //List<Student> students;

    private  ArrayList name, nota1, nota2, media, status;


    public MyAdapter(Context context, ArrayList name, ArrayList nota1, ArrayList nota2, ArrayList media, ArrayList status) {
        this.context = context;
        this.name = name;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = media;
        this.status = status;
    }

    private int position;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.itemview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.nameview.setText(name.get(position).toString());
        holder.nota1view.setText(nota1.get(position).toString());
        holder.nota2view.setText(nota2.get(position).toString());
        holder.mediaview.setText(media.get(position).toString());
        holder.statusview.setText(status.get(position).toString());
    }

    private void update() {

    }

    private void remove(){

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}


