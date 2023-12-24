package com.example.m202195027;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnHome, btnTemper, btnLike, btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("202195027 오화실");

        btnHome = (Button) findViewById(R.id.btnHome);
        btnTemper = (Button) findViewById(R.id.btnTemper);
        btnLike = (Button) findViewById(R.id.btnLike);
        btnBook = (Button) findViewById(R.id.btnBook);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://computer.silla.ac.kr"));
                startActivity(hIntent);
            }
        });

        btnTemper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tIntent = new Intent(getApplicationContext(), TemperActivity.class);
                startActivity(tIntent);
            }
        });

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lIntent = new Intent(getApplicationContext(), LikeActivity.class);
                startActivity(lIntent);
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bIntent = new Intent(getApplicationContext(), BookActivity.class);
                startActivity(bIntent);
            }
        });

    }
}