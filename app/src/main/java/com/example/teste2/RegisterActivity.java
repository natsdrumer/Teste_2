package com.example.teste2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.teste2.db.MyDataSource;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName, edtNota1, edtNota2;
    Button btnCancel, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.eName);
        edtNota1 = findViewById(R.id.eNota1);
        edtNota2 = findViewById(R.id.eNota2);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);

        MyDataSource dataSource = new MyDataSource(this);
        dataSource.open();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtName.setText("");
                edtNota1.setText("");
                edtNota2.setText("");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edtName.getText().toString().trim();
                Double nota1 = Double.valueOf(edtNota1.getText().toString());
                Double nota2 = Double.valueOf(edtNota2.getText().toString());
                Double media = (nota1 + nota2)/2;
                String status;

                if (media<10){
                    status = "Exame";
                }else{
                    status = "Aprovado";
                }

                dataSource.insertData(name, nota1, nota2, media, status);

                edtName.setText("");
                edtNota1.setText("");
                edtNota2.setText("");


            }
        });
    }
}