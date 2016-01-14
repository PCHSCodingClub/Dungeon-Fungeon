package com.blogspot.darokrithia.dungeonfungeon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Credits extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }
    public void onCreditsBackClick (View v){
        if (v.getId() == R.id.CreditsBack) {
            Intent j = new Intent(Credits.this, MainActivity.class);
            startActivity(j);
        }
    }
}
