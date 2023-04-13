package com.example.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRem;
    TextView textResult;
    String num1, num2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기_202195027 오화실");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRem = (Button) findViewById(R.id.BtnRem);

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if ((num1.equals("")) || (num2.equals(""))) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }

                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if ((num1.equals("")) || (num2.equals(""))) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if ((num1.equals("")) || (num2.equals(""))) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if ((num1.equals("")) || (num2.equals(""))) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요!", Toast.LENGTH_SHORT).show();
                }
                else if ( num1.equals("0") || (num2.equals("0"))) {
                    Toast.makeText(getApplicationContext(), "계산할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    //String result1 = String.format("%.2f", result);
                    textResult.setText("계산 결과 : " + String.format("%.2f", result));
                }
                return false;
            }
        });

        btnRem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if ((num1.equals("")) || (num2.equals(""))) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요!", Toast.LENGTH_SHORT).show();
                }
                else if ((num1.equals("0")) || (num2.equals("0"))) {
                    Toast.makeText(getApplicationContext(), "계산할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    //String result1 = String.format("%.2f", result);
                    textResult.setText("계산 결과 : " + String.format("%.2f", result));
                }
                return false;
            }
        });
    }
}
