package com.example.teamproject_healthyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FoodActivity extends AppCompatActivity {

    Button btnTo, btnPrv;
    TextView total;
    Integer Kcal[] = {310, 292, 321, 68, 57, 93, 2, 14, 19, 227};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

            setTitle("금일 식단 입력");

            total = (TextView) findViewById(R.id.total);
            btnTo = (Button) findViewById(R.id.btnTo);
            btnPrv = (Button) findViewById(R.id.btnPrv);

            TextView tv[] = new TextView[10];
            EditText edit[] = new EditText[10];

            Integer textID[] = {R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5,
                    R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9, R.id.textView10};
            Integer editID[] = {R.id.edit1, R.id.edit2, R.id.edit3, R.id.edit4, R.id.edit5,
                    R.id.edit6, R.id.edit7, R.id.edit8, R.id.edit9, R.id.edit10};

            for (int i = 0; i < textID.length; i++) {
                tv[i] = findViewById(textID[i]);
                edit[i] = findViewById(editID[i]);
            }

            // 칼로리 계산한 총 합 textView 출력 & 메인 하단에 값 출력
            btnTo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int sum = 0;
                    for (int i = 0; i < 10; i++) {
                        sum += (Kcal[i] * Integer.parseInt(edit[i].getText().toString()));
                    }

                    total.setText("금일 먹은 총량 : " + sum + "Kcal");
                    Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                    outIntent.putExtra("Result_eat", sum);
                    setResult(7777, outIntent);
                }
            });

            // 이전화면으로 되돌아가기
            btnPrv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
}