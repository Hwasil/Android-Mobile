package com.example.ch6_tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.widget.TabHost;

@SuppressWarnings("depreccation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("202195027 dhghktlf");

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecDog = tabHost.newTabSpec("dog").setIndicator("강아지");
        tabSpecDog.setContent(R.id.dog);
        tabHost.addTab(tabSpecDog);

        TabHost.TabSpec tabSpecCat = tabHost.newTabSpec("cat").setIndicator("고양이");
        tabSpecCat.setContent(R.id.cat);
        tabHost.addTab(tabSpecCat);

        TabHost.TabSpec tabSpecRab = tabHost.newTabSpec("rabbit").setIndicator("토끼");
        tabSpecRab.setContent(R.id.rabbit);
        tabHost.addTab(tabSpecRab);

        TabHost.TabSpec tabSpecFox = tabHost.newTabSpec("fox").setIndicator("여우");
        tabSpecFox.setContent(R.id.fox);
        tabHost.addTab(tabSpecFox);

        tabHost.setCurrentTab(0);
    }
}