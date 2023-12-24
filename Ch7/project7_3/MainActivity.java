package com.example.project7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tvName, tvEmail;
    Button button;
    EditText dlgedit1, dlgedit2;
    TextView tstext;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("202195027 dhghktlff");

        tvName = findViewById(R.id.textView);
        tvEmail =  findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);;
                dlg.setTitle("사용자 정보 입력");
                //dlg.setIcon((R.drawable.ic_menu_))
                dlg.setView(dialogView);

                dlgedit1 = (EditText) dialogView.findViewById(R.id.edit1);
                dlgedit2 = (EditText) dialogView.findViewById(R.id.edit2);

                dlgedit1.setText(tvName.getText());
                dlgedit2.setText(tvEmail.getText());

                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvName.setText(dlgedit1.getText());
                                tvEmail.setText(dlgedit2.getText());
                            }
                        });

                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast toast = new Toast(MainActivity.this);
                                toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                                tstext = (TextView) toastView.findViewById(R.id.toasttext1);
                                tstext.setText("취소했습니다.");

                                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                                int x0ffset = (int) (Math.random() * display.getWidth());
                                int y0ffset = (int) (Math.random() * display.getHeight());

                                toast.setView(toastView);
                                toast.setGravity(Gravity.TOP | Gravity.LEFT, x0ffset, y0ffset);
                                toast.show();
                            }
                        });
                dlg.show();
            }
        });


    }
}