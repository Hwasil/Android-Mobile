package com.example.ch10_3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> ActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("202195027 dhghktlf");

        Button btnnew = (Button) findViewById(R.id.btnnew);
        btnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtnum1 = (EditText) findViewById(R.id.edtnum1);
                EditText edtnum2 = (EditText) findViewById(R.id.edtnum2);
                Intent intent = new Intent(getApplicationContext(), Second.class);
                intent.putExtra("num1", Integer.parseInt(edtnum1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(edtnum2.getText().toString()));
                ActivityResultLauncher.launch(intent);
            }
        });

        ActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                int hap = intent.getIntExtra("Hap", 0);
                //Toast.makeText(getApplicationContext(), "합계 : " + hap, Toast.LENGTH_SHORT).show();
                TextView tx = findViewById(R.id.result);
                tx.setText("합계 : " + hap);
            }
        });
    }
}