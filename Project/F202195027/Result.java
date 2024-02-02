package com.example.f202195027;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;
    TextView textAll;
    Button btnPrev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("bookDB 조회");

        textAll = findViewById(R.id.textAll);
        btnPrev = findViewById(R.id.btnPrev);
        //helper = new DBHelper(this);

        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM bookDB", null);
        String s = "Id Title Name Sentence \r\n";
        while (cursor.moveToNext()) {
            s += cursor.getString(0) + " ";
            s += cursor.getString(1) + " ";
            s += cursor.getString(2) + " ";
        }
        textAll.setText(s);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}