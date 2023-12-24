package com.example.teamproject_2023_1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> activityResultLauncher;

    TextView tvEat, tvRun;
    float Total_eat = 0;
    float Total_run = 0;
    Button btnEat, btnRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 하단부");

        btnEat = findViewById(R.id.btnEat);
        btnRun = findViewById(R.id.btnRun);
        tvEat = findViewById(R.id.tvEat);
        tvRun = findViewById(R.id.tvRun);

        btnEat.setOnClickListener(new View.OnClickListener() { // 칼로리 입력 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), input_food.class);
                activityResultLauncher.launch(intent);
            }
        });

        btnRun.setOnClickListener(new View.OnClickListener() { // 활동량 입력 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), input_energy.class);
                activityResultLauncher.launch(intent);
            }
        });

        // total 값 가져 와서 출력
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();

                // 새로 가져오는 값
                float eat = intent.getFloatExtra("Result_eat", 0);
                float run = intent.getFloatExtra("Result_run", 0);
                // 누적
                Total_eat += eat;
                Total_run += run;

                tvEat.setText("섭취한 칼로리 : " + Total_eat + "Kcal");
                tvRun.setText("활동한 칼로리 : " + Total_run + "Kcal");
            }
        });
    }
}