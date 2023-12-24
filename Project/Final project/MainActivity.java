package com.example.teamproject_2023_1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> activityResultLauncher;

    TextView tvNece, tvEat, tvRun;
    Button btnEat, btnRun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 하단부");

        btnEat = (Button) findViewById(R.id.btnEat);
        btnRun = (Button) findViewById(R.id.btnRun);
        tvEat = (TextView) findViewById(R.id.tvEat);
        tvRun = (TextView) findViewById(R.id.tvRun);

        btnEat.setOnClickListener(new View.OnClickListener() { // 칼로리 입력 이동
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), input_food.class);
                activityResultLauncher.launch(intent1);
            }
        });

        tvRun.setOnClickListener(new View.OnClickListener() { // 칼로리 입력 이동
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), input_energy.class);
                activityResultLauncher.launch(intent2);
            }
        });

        // total값 가져와서 출력 (실행해보기!! & rsult 가 뭔지 확인하기)
        //float Total_eat=0.0F, Total_run = 0.0F; // 누적
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                float eat = intent.getIntExtra("Result_eat", 0); // 새로 가져오는 값
                float run = intent.getIntExtra("Result_run", 0);
                float Total_eat =+ eat;
                float Total_run =+ run;

                tvEat.setText("섭취한 칼로리 : " + Total_eat + "Kcal");
                tvRun.setText("활동한 칼로리 : " + Total_run + "Kcal");
            }
        });
    }


}