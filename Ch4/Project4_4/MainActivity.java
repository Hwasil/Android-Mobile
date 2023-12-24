package com.example.project4_4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView2;
    Switch chkAgree;
    RadioGroup RGroup;
    RadioButton Rcat, Rdog, Rrabbit;
    ImageView imagePet;
    Button btnExit, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        textView2 = (TextView) findViewById(R.id.textView2);
        chkAgree = (Switch) findViewById(R.id.chkAgree);

        RGroup = (RadioGroup) findViewById(R.id.RGroup);
        Rcat = (RadioButton) findViewById(R.id.Rcat);
        Rdog = (RadioButton) findViewById(R.id.Rdog);
        Rrabbit = (RadioButton) findViewById(R.id.Rrabbit);

        imagePet = (ImageView) findViewById(R.id.imagePet);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnReset = (Button) findViewById(R.id.btnReset);

        imagePet.setImageResource(0);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkAgree.isChecked() == true) {
                    textView2.setVisibility(View.VISIBLE);
                    RGroup.setVisibility(View.VISIBLE);
                    imagePet.setVisibility(View.VISIBLE);
                    btnExit.setVisibility(View.VISIBLE);
                    btnReset.setVisibility(View.VISIBLE);
                } else {
                    textView2.setVisibility(View.INVISIBLE);
                    RGroup.setVisibility(View.INVISIBLE);
                    imagePet.setVisibility(View.INVISIBLE);
                    btnExit.setVisibility(View.INVISIBLE);
                    btnReset.setVisibility(View.INVISIBLE);
                }
            }
        });

        RGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (RGroup.getCheckedRadioButtonId()) {
                    case R.id.Rcat:
                        imagePet.setImageResource(R.drawable.cat1);
                        break;
                    case R.id.Rdog :
                        imagePet.setImageResource(R.drawable.dog2);
                        break;
                    case R.id.Rrabbit :
                        imagePet.setImageResource(R.drawable.rabbit);
                        break;
                }
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkAgree.setChecked(false);
                Rcat.setChecked(false);
                Rdog.setChecked(false);
                Rrabbit.setChecked(false);
                imagePet.setImageResource(0);
            }
        });
    }
}

