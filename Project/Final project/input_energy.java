package com.example.teamproject_2023_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class input_energy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_energy);
        setTitle("금일 활동량 입력");

        RadioGroup rdGroup;
        EditText editM, editKg; //
        TextView total;
        Button btnTo, btnPrv;


        RadioButton rd[] = new RadioButton[9];

        Integer radioID[] = {R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4, R.id.rb5,
                            R.id.rb6, R.id.rb7, R.id.rb8, R.id.rb9};

        for (int i = 0; i < 9; i++) {
            rd[i] = (RadioButton) findViewById(radioID[i]);
        }

        rdGroup = findViewById(R.id.rdGroup);
        editM = findViewById(R.id.editM);
        editKg = findViewById(R.id.editKg);
        total = (TextView) findViewById(R.id.total);
        btnTo = (Button) findViewById(R.id.btnTo);
        btnPrv = (Button) findViewById(R.id.btnPrv);

        // 활동량 계산한 총 합 textView 출력 & 메인 하단에 값 출력
        btnTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float met, sum = 0;
                float kg = Float.parseFloat(editKg.getText().toString());
                float m = Float.parseFloat(editM.getText().toString());

                switch (rdGroup.getCheckedRadioButtonId()) {
                    case R.id.rb1:
                        met = (float) (3.5 * 1 * kg * m) / 1000 * 5;
                        sum += met;
                        break;
                    case R.id.rb2:
                        met = (float) (3.5 * 2.3 * kg * m)/ 1000 * 5;
                        sum += met;
                        break;
                    case R.id.rb3:
                        met = (float) (3.5 * 4.5 * kg * m) / 1000 * 5;
                        sum += met;
                        break;
                    case R.id.rb4:
                        met = (float) (3.5 * 6 * kg * m) / 1000 * 5;
                        sum += met;
                        break;
                    case R.id.rb5:
                        met = (float) (3.5 * 6.5 * kg * m) / 1000 * 5;
                        sum += met;
                        break;
                    case R.id.rb6:
                        met = (float) (3.5 * 7 * kg * m) / 1000 * 5;
                        sum += met;
                        break;
                    case R.id.rb7:
                        met = (float) (3.5 * 7.3 * kg * m) / 1000 * 5;
                        sum += met;
                        break;
                    case R.id.rb8:
                        met = (float) (3.5 * 8 * kg * m) / 1000 * 5;
                        sum += met;
                        break;
                    case R.id.rb9:
                        met = (float) (3.5 * 10 * kg * m) / 1000 * 5;
                        sum += met;
                        break;
                }

                total.setText("금일 활동량 : " + sum + "Kcal");
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Result_run", sum);
                setResult(RESULT_OK, outIntent);
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