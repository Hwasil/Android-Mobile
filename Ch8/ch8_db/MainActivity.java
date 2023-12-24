package com.example.ch8_db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
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
    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION = 2;
    // 세번째 인수 factory 표준 cursor를 이용할 경우 null 로 지정
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contacts (_id INTEGER PRIMARY KEY AUTOINCREMENT, name text, tel text);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }
}
public class MainActivity extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    EditText editName, editPhone;
    TextView textAll;
    Button insert, search, select, delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        textAll = findViewById(R.id.textAll);
        insert = findViewById(R.id.button);
        search = findViewById(R.id.button2);
        select = findViewById(R.id.button3);
        delete = findViewById(R.id.button4);

        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();
        } catch (SQLException ex) {
            //DB 읽기, DB가 없다면 onCreate가 호출되고, version이 바뀌었다면 onUpgrade 호출
            db = helper.getReadableDatabase();

        }

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String tel = editPhone.getText().toString();
                db.execSQL("INSERT INTO contacts VALUES (null, '" + name + "', '" + tel + "');");
                //Toast.makeText(getApplicationContext(), "성공적으로 추가되었음", Toast.LENGTH_LONG).show();
                editName.setText("");
                editPhone.setText("");
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                Cursor cursor;
                cursor = db.rawQuery("SELECT name, tel FROM contacts WHERE name = '" + name + "';", null);
                while (cursor.moveToNext()) {
                    String tel = cursor.getString(1);
                    editPhone.setText(tel);
                }
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor;
                cursor = db.rawQuery("SELECT * FROM contacts", null);
                String s = "Id Name Tel \r\n";
                while (cursor.moveToNext()) {
                    s += cursor.getString(0) + " ";
                    s += cursor.getString(1) + " ";
                    s += cursor.getString(2) + " \r\n";
                }
                textAll.setText(s);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String tel = editPhone.getText().toString();
                //db.execSQL("DELETE FROM contacts WHERE name =" + name + " AND tel =" + tel);
                db.execSQL("DELETE FROM contacts WHERE name = '" + name + "';");
                Toast.makeText(getApplicationContext(), "성공적으로 삭제되었음", Toast.LENGTH_LONG).show();
                editName.setText("");
                editPhone.setText("");
                }

        });
    }
}


