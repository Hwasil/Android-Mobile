package com.example.checkbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    CheckBox chkDog, chkCat;
    ImageView imageDog, imageCat;
    RadioGroup radioGroup;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("동물선택_202195027 오화실");

        chkDog = (CheckBox) findViewById(R.id.chkDog);
        chkCat = (CheckBox) findViewById(R.id.chkCat);
        imageDog = (ImageView) findViewById(R.id.imageDog);
        imageCat = (ImageView) findViewById(R.id.imageCat);
        imageDog.setImageResource(0);
        imageCat.setImageResource(0);

        radioGroup = (RadioGroup)findViewById(R.id.rGroup);
        layout = findViewById(R.id.layout);

        chkDog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkDog.isChecked() == true) {
                    //imageDog.setVisibility(View.VISIBLE);
                    imageDog.setImageResource(R.drawable.dog);
                } else {
                    //imageDog.setVisibility(View.INVISIBLE);
                    imageDog.setImageResource(0);
                }
            }
        });

        chkCat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkCat.isChecked() == true) {
                    //imageCat.setVisibility(View.VISIBLE);
                    imageCat.setImageResource(R.drawable.cat2);
                } else {
                    //imageCat.setVisibility(View.INVISIBLE);
                    imageCat.setImageResource(0);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.red) {
                    layout.setBackgroundColor(Color.RED);
                }
                else if(checkedId == R.id.blue) {
                    layout.setBackgroundColor(Color.BLUE);
                }
                else if(checkedId == R.id.white) {
                    layout.setBackgroundColor(Color.WHITE);
                }
            }
        });
    }
}
