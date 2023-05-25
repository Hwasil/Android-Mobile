package com.example.checkbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RadioActivity extends AppCompatActivity {
    RadioGroup rGroup;
    LinearLayout layout;
    Button btnNext;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        setTitle("Radio 202195027 오화실");

        btnNext = findViewById(R.id.btnNext);
        rGroup = (RadioGroup)findViewById(R.id.rGroup);
        layout = findViewById(R.id.layout);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == R.id.red) {
//                    layout.setBackgroundColor(Color.RED);
//                }
//                else if(checkedId == R.id.blue) {
//                    layout.setBackgroundColor(Color.BLUE);
//                }
//                else if(checkedId == R.id.white) {
//                    layout.setBackgroundColor(Color.WHITE);
//                }
//            }
//        });
    }

    public void onRadioClicked(View view) {
        switch (view.getId()) {
            case R.id.red:
                layout.setBackgroundColor(Color.RED);
                break;
            case R.id.blue :
                layout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.white :
                layout.setBackgroundColor(Color.WHITE);
                break;
        }
    }
}
