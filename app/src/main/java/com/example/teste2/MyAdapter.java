package com.example.teste2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.teste2.model.Student;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Student> students;

    //MyViewHolder holder;

    public MyAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    private int position;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.itemview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.nameview.setText(students.get(position).getName());
        holder.nota1view.setText(students.get(position).getNota1().toString());
        holder.nota2view.setText(students.get(position).getNota2().toString());
        holder.mediaview.setText(students.get(position).getMedia().toString());
        holder.statusview.setText(students.get(position).getStatus());




    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}


