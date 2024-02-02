package com.example.project11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("GridView / ListView Movie Poster");


/*        final GridView gv = findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter); */

        Integer[] posterID = {R.drawable.mov01, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov12, R.drawable.mov14, R.drawable.mov16, R.drawable.mov17, R.drawable.mov20,
                R.drawable.mov01, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov12, R.drawable.mov14, R.drawable.mov16, R.drawable.mov17, R.drawable.mov20,
                R.drawable.mov01, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov12, R.drawable.mov14, R.drawable.mov16, R.drawable.mov17, R.drawable.mov20};

        final String[] mid = {"토이스토리4", "겨울왕국2", "알라딘", "극한직업", "스파이더맨 파 프롬 홈", "주먹왕 랄프2", "걸캅스",
                "어벤져스 엔드게임", "엑시트", "분노의 질주",
                "토이스토리4", "겨울왕국2", "알라딘", "극한직업", "스파이더맨 파 프롬 홈", "주먹왕 랄프2", "걸캅스", "어벤져스 엔드게임",
                "엑시트", "분노의 질주",
                "토이스토리4", "겨울왕국2", "알라딘", "극한직업", "스파이더맨 파 프롬 홈", "주먹왕 랄프2", "걸캅스", "어벤져스 엔드게임",
                "엑시트", "분노의 질주"};

        ListView list = findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mid);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View dialogView = View.inflate(MainActivity.this, R.layout.activity_dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(posterID[position]);
                //dlg.setTitle("Big Poster");
                dlg.setTitle((mid[position]));
                dlg.setView(R.drawable.ic_launcher_foreground);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
    }

    /*
    public class MyGridAdapter extends BaseAdapter {
        Context context;
        public MyGridAdapter(Context c) {
            context = c;
        }
        public int getCount() {
            return posterID.length;
        }
        public Object getItem(int arg0) {
            return null;
        }
        public long getItemId(int arg0) {
            return 0;
        }

        Integer[] posterID = {R.drawable.mov01, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov12, R.drawable.mov14, R.drawable.mov16, R.drawable.mov17, R.drawable.mov20,
                R.drawable.mov01, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov12, R.drawable.mov14, R.drawable.mov16, R.drawable.mov17, R.drawable.mov20,
                R.drawable.mov01, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov12, R.drawable.mov14, R.drawable.mov16, R.drawable.mov17, R.drawable.mov20};

        public View getView(int position, View arg1, ViewGroup arg2) {
            ImageView  imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(posterID[position]);

            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = View.inflate(MainActivity.this, R.layout.activity_dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    //dlg.setTitle("Big Poster");
                    dlg.setView(R.drawable.ic_launcher_foreground);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageView;
        }
    } */

}