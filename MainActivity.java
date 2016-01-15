package com.blogspot.darokrithia.dungeonfungeon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onCreditsClick(View v) {
        if (v.getId() == R.id.CreditsButton) {
            Intent i = new Intent(MainActivity.this, CreditsActivity.class);
            startActivity(i);
        }
    }
    public void onStartClick(View v) {
        if (v.getId() == R.id.StartButton) {
            Intent i = new Intent(MainActivity.this, StartActivity.class);
            startActivity(i);
        }
    }
}
