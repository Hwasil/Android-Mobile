package com.example.teamproject_healthyapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> activityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Spinner spinnerAct = (Spinner) findViewById(R.id.spinnerAct);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton maleRb = (RadioButton) findViewById(R.id.rbMale);
        RadioButton femaleRb = (RadioButton) findViewById(R.id.rbFemale);
        TextView dateTv = (TextView) findViewById(R.id.tvDate);
        EditText kcalEt = (EditText) findViewById(R.id.etKcal);
        EditText nameEt = (EditText) findViewById(R.id.etName);
        EditText ageEt = (EditText) findViewById(R.id.etAge);
        EditText heightEt = (EditText) findViewById(R.id.etHeight);
        EditText weightEt = (EditText) findViewById(R.id.etWeight);
        Button returnBtn = (Button) findViewById(R.id.btnReturn);
        Button dateBtn = (Button) findViewById(R.id.btnDate);

        ArrayAdapter activityAdapter = ArrayAdapter.createFromResource(this,
                R.array.activity_coefficient, android.R.layout.simple_spinner_dropdown_item);
        spinnerAct.setAdapter(activityAdapter);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dateIntent = new Intent(getApplicationContext(), DatePickerActivity.class);
                activityResultLauncher.launch(dateIntent);
            }
        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == 4444) {
                        Intent intent = result.getData();
                        int dateY = intent.getIntExtra("mYear", 0);
                        int dateM = intent.getIntExtra("mMonth", 0);
                        int dateD = intent.getIntExtra("mDay", 0);
                        dateTv.setText(dateY + "-" + (dateM + 1) + "-" + dateD);
                    }
                });
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int height, weight, age, kcal, result = 0;

                kcal = Integer.parseInt(kcalEt.getText().toString());
                height = Integer.parseInt(heightEt.getText().toString());
                weight = Integer.parseInt(weightEt.getText().toString());
                age = Integer.parseInt(ageEt.getText().toString());

                String activity = spinnerAct.getSelectedItem().toString();

                if(maleRb.isChecked()) {
                    result = (int)((6.25 * height) + (10 * weight) - (5 * age) + 5);
                    if(activity.equals("비활동적")) {
                        result = (int)(result * 1.0);
                    }
                    else if(activity.equals("저활동적")) {
                        result = (int)(result * 1.11);
                    }
                    else if(activity.equals("활동적")) {
                        result = (int)(result * 1.25);
                    }
                    else {
                        result = (int)(result * 1.48);
                    }
                }
                else if(femaleRb.isChecked()) {
                    result = (int)((6.25 * height) + (10 * weight) - (5 * age) - 161);
                    if(activity.equals("비활동적")) {
                        result = (int)(result * 1.0);
                    }
                    else if(activity.equals("저활동적")) {
                        result = (int)(result * 1.12);
                    }
                    else if(activity.equals("활동적")) {
                        result = (int)(result * 1.27);
                    }
                    else {
                        result = (int)(result * 1.45);
                    }
                }
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Kcal", result - kcal);
                outIntent.putExtra("Date", dateTv.getText());
                outIntent.putExtra("Name", nameEt.getText().toString());
                setResult(5555, outIntent);
                finish();
            }
        });
    }
}