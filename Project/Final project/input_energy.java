package com.example.teamproject_2023_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class input_food extends AppCompatActivity {
    Button btnTo, btnPrv;
    TextView total;
    Float Energy[] = {}; //
    float sum = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_food);
        setTitle("금일 활동량 입력");

        TextView tv[] = new TextView[9];

        Integer textID[] = {R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4, R.id.rb5,
                R.id.rb6, R.id.rb7, R.id.rb8, R.id.rb9, R.id.rb10};
       
        for (int i = 0; i < 9; i++) {
            tv[i] = findViewById(textID[i]);
        }

		

	total = (TextView) findViewById(R.id.total);
        btnTo = (Button) findViewById(R.id.btnTo);
        btnPrv = (Button) findViewById(R.id.btnPrv);

        // 활동량 계산한 총 합 textView 출력 & 메인 하단에 값 가져가기
        btnTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 9; i++) {
                    sum += (Energy[i] * Float.parsefloat(edit[i].getText().toString()));
                }

                total.setText("금일 활동 총량 : " + sum + "Kcal");
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Result_run", sum);
                setResult(RESULT_OK, outIntent); // result_ok가 동시에 안되면 2로 변경
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
