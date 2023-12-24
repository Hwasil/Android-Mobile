package com.example.m202195027;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TimePicker;

public class BookActivity extends AppCompatActivity {
    CalendarView calView;
    TimePicker Timep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        setTitle("202195027 오화실");

        calView = (CalendarView) findViewById(R.id.calView);
        Timep = (TimePicker) findViewById(R.id.Timep);

        calView.setVisibility(View.INVISIBLE);
        Timep.setVisibility(View.INVISIBLE);
    }
}