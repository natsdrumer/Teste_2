package com.example.teste2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
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

    ArrayList<String> status, name;
    ArrayList<Double> nota1, nota2, media;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproved);
        dataSource = new MyDataSource(this);
        dataSource.open();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = new ArrayList<>();
        nota1 = new ArrayList<>();
        nota2 = new ArrayList<>();
        media = new ArrayList<>();
        status = new ArrayList<>();


        recyclerView = findViewById(R.id.recyclerReprov);
        adapter = new MyAdapter(this, name, nota1, nota2, media, status);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {

        Cursor cursor = dataSource.getAllReproved();

        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(), "No entrys", Toast.LENGTH_LONG).show();
        }else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(1));
                nota1.add(cursor.getDouble(2));
                nota2.add(cursor.getDouble(3));
                media.add(cursor.getDouble(4));
                status.add(cursor.getString(5));
            }
            adapter.notifyDataSetChanged();
        }
    }
}