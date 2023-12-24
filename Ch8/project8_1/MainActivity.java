package com.example.project8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.XMLFormatter;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    EditText editDiary;
    TextView info;
    Button btnWrite, btnDelete;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Diary");

        dp = findViewById(R.id.datePicker);
        editDiary = findViewById(R.id.edtDiary);
        info = findViewById(R.id.info);
        btnWrite = findViewById(R.id.btnWrite);
        btnDelete = findViewById(R.id.btnDelete);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);
        
        // 초깃값이 있어야 날짜 변경이 없어도 입력이 가능함

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear + 1) + "_" + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);
                editDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = editDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    //Toast.makeText(getApplicationContext(), fileName + "저장 완료 ", Toast.LENGTH_SHORT).show();
                    info.setText(fileName + "저장 완료");
                } catch (IOException e) {
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFile(fileName);
                editDiary.setHint("");
                editDiary.setHint("내용 없음");
                //Toast.makeText(getApplicationContext(), fileName + "삭제 완료 ", Toast.LENGTH_SHORT).show();
                info.setText(fileName + "삭제 완료");
            }
        });
    }

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;

        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정");
        } catch (IOException e) {
            editDiary.setHint("내용 없음");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }
}