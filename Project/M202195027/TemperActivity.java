package com.example.m202195027;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class TemperActivity extends AppCompatActivity {

    EditText editText;
    RadioGroup rGroup;
    RadioButton rb1, rb2;
    Button btnChg;
    TextView textView;
    double celsius, fahrenheit, result;
    String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temper);
        setTitle("202195027 오화실");

        editText = (EditText) findViewById(R.id.editText);
        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        btnChg = (Button) findViewById(R.id.btnChg);
        textView = (TextView) findViewById(R.id.textView);

        btnChg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = editText.getText().toString();
                
                if (num.equals("")) {
                    Toast.makeText(getApplicationContext(), "값이 비어 있음", Toast.LENGTH_SHORT).show();
                }
                else if (rGroup.getCheckedRadioButtonId() == R.id.rb1) {
                    celsius = Double.parseDouble(num);
                    result = (celsius * 9)/5 + 32.0;
                } else {
                    fahrenheit = Double.parseDouble(num);
                    result = (fahrenheit - 32) * 5 / 9.0;
                }

                textView.setText(result.toString());
            }
        });

    }
}

