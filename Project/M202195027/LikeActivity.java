package com.example.m202195027;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class LikeActivity extends AppCompatActivity {

    CheckBox kim, ra, sand, piz, ham;
    Button done, reset;
    TextView returntext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        setTitle("202195027 오화실");

        kim = (CheckBox) findViewById(R.id.kim);
        ra = (CheckBox) findViewById(R.id.ra);
        sand = (CheckBox) findViewById(R.id.sand);
        piz = (CheckBox) findViewById(R.id.piz);
        ham = (CheckBox) findViewById(R.id.ham);
        done = (Button) findViewById(R.id.done);
        reset = (Button) findViewById(R.id.reset);
        returntext = (TextView) findViewById(R.id.returntext);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returntext.setText();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kim.setChecked(false);
                ra.setChecked(false);
                piz.setChecked(false);
                sand.setChecked(false);
                ham.setChecked(false);
            }
        });

    }
}