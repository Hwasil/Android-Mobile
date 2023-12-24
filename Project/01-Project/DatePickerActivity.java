package com.example.teamproject_healthyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatePickerActivity extends AppCompatActivity {

    private int mYear = 0, mMonth = 0, mDay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_date_picker);
        setTitle("시작 날짜 입력하기");

        Calendar calendar = new GregorianCalendar();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(calendar.MONTH);
        mDay = calendar.get(calendar.DAY_OF_MONTH);

        DatePicker datePicker = findViewById(R.id.datePicker1);

        DatePicker.OnDateChangedListener mOnDateChangedListener = new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int yy, int mm, int dd) {
                mYear = yy;
                mMonth = mm;
                mDay = dd;
            }
        };

        datePicker.init(mYear, mMonth, mDay, mOnDateChangedListener);

        Button btnDate = (Button) findViewById(R.id.dateBtn);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("mYear", mYear);
                intent.putExtra("mMonth", mMonth);
                intent.putExtra("mDay", mDay);
                setResult(4444, intent);
                finish();
            }
        });
    }
}