package com.example.teste2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.teste2.db.DbHelper;
import com.example.teste2.db.MyDataSource;
import com.example.teste2.model.Student;

import java.util.ArrayList;

public class ReprovedActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Student> students;
    MyDataSource dataSource;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproved);
        dataSource = new MyDataSource(this);
        dataSource.open();
        students = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerReprov);
        adapter = new MyAdapter(this, students);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        students = dataSource.getAllReproved();
        if(students.size() == 0){
            Toast.makeText(getApplicationContext(), "No entrys", Toast.LENGTH_LONG).show();
        }else {
            adapter.notifyItemInserted(0);
        }
    }
}