package com.example.teamproject_healthyapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> activityResultLauncher;

    FeedReaderDbHelper helper;
    SQLiteDatabase db;

    TextView tvEat, tvRun, tvNece, tvData;
    Button btnEat, btnRun, btnSave;

    float totalEat, totalEnergy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultTv4 = (TextView) findViewById(R.id.tvResult4);
        TextView resultTv5 = (TextView) findViewById(R.id.tvResult5);
        TextView resultTv6 = (TextView) findViewById(R.id.tvResult6);

        Button profileBtn = (Button) findViewById(R.id.btn_Profile);

        btnEat = findViewById(R.id.btnEat);
        btnRun = findViewById(R.id.btnRun);
        btnSave = findViewById(R.id.btnSave);
        tvEat = findViewById(R.id.tvEat);
        tvRun = findViewById(R.id.tvRun);
        tvNece = findViewById(R.id.tvNece);
        tvData = findViewById(R.id.tvData);

        helper = new FeedReaderDbHelper(this);
        try {
            db = helper.getWritableDatabase();
        } catch(SQLException ex) {
            db = helper.getReadableDatabase();
        }

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                activityResultLauncher.launch(intent);
            }
        });

        btnEat.setOnClickListener(new View.OnClickListener() { // 칼로리 입력 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FoodActivity.class);
                activityResultLauncher.launch(intent);
                //startActivity(intent);
            }
        });

        btnRun.setOnClickListener(new View.OnClickListener() { // 활동량 입력 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EnergyActivity.class);
                activityResultLauncher.launch(intent);
                //startActivity(intent);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor1, cursor2;
                String name = resultTv4.getText().toString();
                String date = resultTv5.getText().toString();
                String kcal = tvEat.getText().toString();

                cursor1 = db.rawQuery("SELECT * FROM dietdata", null);
                cursor2 = db.rawQuery("SELECT AVG(kcal) FROM dietdata", null);
                cursor2.moveToFirst();
                db.execSQL("INSERT INTO dietdata VALUES (null, '" + name + "', '" + date + "', '" + kcal + "');");

                Toast.makeText(getApplicationContext(), "저장 완료", Toast.LENGTH_LONG).show();

                String s = "Id  이름                   날짜                 칼로리     평균 : "
                        + cursor2.getString(0) + "\r\n";
                while (cursor1.moveToNext()) {
                    s += cursor1.getString(0) + "  ";
                    s += cursor1.getString(1) + "        ";
                    s += cursor1.getString(2) + "        ";
                    s += cursor1.getString(3) + "    \r\n";
                }
                tvData.setText(s);
                totalEat = 0;
                totalEnergy = 0;
                tvEat.setText("0");
                tvRun.setText("0");
            }

        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
            if(result.getResultCode() == 5555) {
                Intent intent = result.getData();
                String strKcal;
                int kcal = intent.getIntExtra("Kcal", 0);
                String dateTv = intent.getStringExtra("Date");
                String nameTv = intent.getStringExtra("Name");
                strKcal = String.valueOf(kcal);
                resultTv4.setText(nameTv);
                resultTv5.setText(dateTv);
                tvNece.setText( strKcal + "Kcal");
            }
            if (result.getResultCode() == 6666) {
                Intent intent = result.getData();
                // 새로 가져오는 값
                String strRun;
                int run = intent.getIntExtra("Result_run", 0);
                totalEnergy += run;
                // 누적
                strRun = String.valueOf(totalEnergy);
                tvRun.setText( strRun + "Kcal");
            }
            if (result.getResultCode() == 7777) {
                Intent intent = result.getData();
                // 새로 가져오는 값
                String strEat;
                int eat = intent.getIntExtra("Result_eat", 0);
                totalEat += eat;
                // 누적
                strEat = String.valueOf(totalEat);
                tvEat.setText( strEat + "Kcal");
                resultTv6.setText(tvEat.getText().toString() + " / " + tvNece.getText().toString());
            }
        });
    }
}