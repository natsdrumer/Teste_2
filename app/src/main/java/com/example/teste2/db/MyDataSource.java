package com.example.teste2.db;

// MyDataSource.java
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.teste2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MyDataSource {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public MyDataSource(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void insertData(String name, Double nota1, Double nota2, Double media, String status) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_NAME, name);
        values.put(DbHelper.COLUMN_NOTA1, nota1);
        values.put(DbHelper.COLUMN_NOTA1, nota2);
        values.put(DbHelper.COLUMN_MEDIA, media);
        values.put(DbHelper.COLUMN_STATUS, status);
        database.insert(DbHelper.TABLE_NAME, null, values);
    }

    public List<Student> getAllData() {
        List<Student> dataList = new ArrayList<>();

        Cursor cursor = database.query(
                DbHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_NAME));
                Double nota1 = cursor.getDouble(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_NOTA1));
                Double nota2 = cursor.getDouble(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_NOTA2));
                Double media = cursor.getDouble(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_MEDIA));
                String status = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_STATUS));
                Student student = new Student(id, name, nota1, nota2, media, status);
                dataList.add(student);
            } while (cursor.moveToNext());

            cursor.close();
        }

        return dataList;
    }

    public void updateData(long id, String newName, Double newNota1, Double newNota2, Double newMedia, String newStatus) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_NAME, newName);
        values.put(DbHelper.COLUMN_NOTA1, newNota1);
        values.put(DbHelper.COLUMN_NOTA1, newNota2);
        values.put(DbHelper.COLUMN_MEDIA, newMedia);
        values.put(DbHelper.COLUMN_STATUS, newStatus);
        String whereClause = DbHelper.COLUMN_ID + "=?";
        String[] whereArgs = {String.valueOf(id)};
        database.update(DbHelper.TABLE_NAME, values, whereClause, whereArgs);
    }

    public void deleteData(long id) {
        String whereClause = DbHelper.COLUMN_ID + "=?";
        String[] whereArgs = {String.valueOf(id)};
        database.delete(DbHelper.TABLE_NAME, whereClause, whereArgs);
    }
}

