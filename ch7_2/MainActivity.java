package com.example.ch7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button btnColor, btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseLayout = findViewById(R.id.baselayout);

        btnColor = findViewById(R.id.btnColor);
        registerForContextMenu(btnColor);
        btnChange = findViewById(R.id.btnChange);
        registerForContextMenu(btnChange);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if ( v == btnColor) {
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu1, menu);
        }

        if ( v == btnChange) {
            menu.setHeaderTitle("버튼 변경");

            mInflater.inflate(R.menu.menu2, menu);
        }
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemR:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemG:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemB:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subR:
                btnChange.setRotation(45);
                return true;
            case R.id.subS:
                btnChange.setScaleX(2);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}