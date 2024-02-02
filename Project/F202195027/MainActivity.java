package com.example.f202195027;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

class DBHelper extends SQLiteOpenHelper {
    public DBHelper (Context context) {
        super(context, "bookDB", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE bookDB (id INTEGER PRIMARY KEY, title text, name text, sentence text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(("DROP TABLE IF EXISTS bookDB"));
        onCreate(db);
    }
}

public class MainActivity extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    EditText editT, editN, editS;
    Button btnSave, btnAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("202195027 오화실");

        editT = findViewById(R.id.editT);
        editN = findViewById(R.id.editN);
        editS = findViewById(R.id.editS);
        btnSave = findViewById(R.id.btnSave);
        btnAll = findViewById(R.id.btnAll);
        helper = new DBHelper(this);

        try {
            db = helper.getWritableDatabase();
        } catch (SQLException ex) {
            db = helper.getReadableDatabase();
        }

        btnSave.setOnClickListener(new View.OnClickListener() { // 저장
            @Override
            public void onClick(View v) {
                String title = editT.getText().toString();
                String name = editN.getText().toString();
                String sentence = editS.getText().toString();

                db.execSQL("INSERT INTO bookDB VALUES (null,'"+ title +"', '"+ name +"', '"+ sentence +"' );");
                Toast.makeText(getApplicationContext(), "성공적으로 추가", Toast.LENGTH_LONG).show();
                editT.setText("");
                editN.setText("");
                editS.setText("");
            }
        });

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Result.class);
                startActivity(intent);
            }
        });
    }


}