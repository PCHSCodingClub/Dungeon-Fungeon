package com.blogspot.darokrithia.dungeonfungeon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by dtabin17 on 1/21/16.
 */
public class ItemSwitcherActivity extends AppCompatActivity{        //Used to switch items in inventory slots
    int itemType;    // lets the class know what kind of item to switch
    @Override
    protected void onCreate(Bundle savedInstanceState){
        itemType = InventoryActivity.itemToSwitch;
        setupItems(itemType);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_switcher);

    }

    public void onBackClick(View v){                //when player clicks back button
        if (v.getId() == R.id.backButton){
            Intent i = new Intent(ItemSwitcherActivity.this, InventoryActivity.class);
            startActivity(i);                       // goes back to inventory screen
        }
    }

    public void  setupItems(int t){
        int[] equippedInventory = RoomActivity.player.getEquipment();
        int[] inventory = RoomActivity.player.getInventory();

        ArrayList <Equipment> totalInventory = new ArrayList<>();


        for (int i = 0; i < equippedInventory.length; i++){
            int ID = equippedInventory[i];
            Equipment e = new Equipment(ID);
            totalInventory.add(e);
        }
        for (int i = 0; i < inventory.length; i++){
            int ID = inventory[i];
            Equipment e = new Equipment(ID);
            totalInventory.add(e);
        }

        switch(t){
            case(0):
                //do stuff
                break;
            case(1):
                //do stuff
                break;
            case(2):
                //do stuff
                break;
            case(3):
                //do stuff
                break;
            case(4):
                //do stuff
                break;
            default:
                Intent i = new Intent (ItemSwitcherActivity.this, InventoryActivity.class);
                break;
        }
    }
}
