package com.blogspot.darokrithia.dungeonfungeon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dtabin17 on 1/21/16.
 */
public class ItemSwitcherActivity extends AppCompatActivity{        //Used to switch items in inventory slots
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_switcher);
    }

    public void onBackClick(View v){                //when player clicks back button
        if (v.getId() == R.id.backButton){
            Intent i = new Intent(ItemSwitcherActivity.this, InventoryActivity.class);
            startActivity(i);                       // goes back to inventory screen
        }
    }
}
