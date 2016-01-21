package com.blogspot.darokrithia.dungeonfungeon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by hkeene17 on 1/12/16.
 */
public class InventoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        //Sets text to being the current total stats for player in the inventory screen.

        ((TextView)findViewById(R.id.NameInventory)).setText(RoomActivity.player.getName()); //name
        ((TextView)findViewById(R.id.HealthInventory)).setText("" + RoomActivity.player.getCurrentHP() + "/" + RoomActivity.player.getMaxHP() + ""); //CurrentHP over MaxHP
        ((TextView)findViewById(R.id.AgilityInventory)).setText(RoomActivity.player.getBaseSpeed()); //Speed
        ((TextView)findViewById(R.id.DefenceInventory)).setText(RoomActivity.player.getDefence()); //Defence
        ((TextView)findViewById(R.id.AttackInventory)).setText(RoomActivity.player.getAttack()); //Attack
        ((TextView)findViewById(R.id.IntellegenceInventory)).setText(RoomActivity.player.getIntelligence()); //Intelligence

    } // Goes to the activity corresponding to the equipment slot.
    public void onArmorSlotClick(View v) {
        if (v.getId() == R.id.ArmorInventory) {
            Intent i = new Intent(InventoryActivity.this, ItemSwitcherActivity.class); //Armor Button
            startActivity(i);
        }
    }
    public void onHelmetSlotClick(View v) {
        if (v.getId() == R.id.HelmetInventory) {
            Intent i = new Intent(InventoryActivity.this, ItemSwitcherActivity.class); //Helmet Button
            startActivity(i);
        }
    }
    public void onLeggingsSlotClick(View v) {
        if (v.getId() == R.id.LeggingsInventory) {
            Intent i = new Intent(InventoryActivity.this, ItemSwitcherActivity.class); //Leggings Button
            startActivity(i);
        }
    }
    public void onBootsSlotClick(View v) {
        if (v.getId() == R.id.BootsInventory) {
            Intent i = new Intent(InventoryActivity.this, ItemSwitcherActivity.class); //Boots Button
            startActivity(i);
        }
    }
    public void onLeftHandSlotClick(View v) {
        if (v.getId() == R.id.LeftHand) {
            Intent i = new Intent(InventoryActivity.this, ItemSwitcherActivity.class); //Left Hand Button
            startActivity(i);
        }
    }
    public void onRightHandSlotClick(View v) {
        if (v.getId() == R.id.RightHand) {
            Intent i = new Intent(InventoryActivity.this, ItemSwitcherActivity.class); //Right Hand Button
            startActivity(i);
        }
    }
}
