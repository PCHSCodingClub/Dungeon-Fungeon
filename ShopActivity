package com.blogspot.darokrithia.dungeonfungeon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLogTags;
import android.view.View;
import android.widget.TextView;

/**
 * Created by hkeene17 on 1/28/16.
 */
public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ((TextView) findViewById(R.id.ShopGoldText)).setText(RoomActivity.player.getGold()); //GoldCount
    }
    public void onBackShopClick(View v){
        if (v.getId() == R.id.BackShopButton){
            Intent i = new Intent(ShopActivity.this, RoomActivity.class);
            startActivity(i);
        }
    }
}
