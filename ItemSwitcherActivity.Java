package com.blogspot.darokrithia.dungeonfungeon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

/**
 * Created by dtabin17 on 1/21/16.
 */
public class ItemSwitcherActivity extends AppCompatActivity{        //Used to switch items in inventory slots

    int currentLocation;
    int currentID;

    ArrayList<Integer> switchToLocation = new ArrayList<>();
    ArrayList<Integer> switchToID = new ArrayList<>();

    int[] equippedInventory = RoomActivity.player.getEquipment();           //here until (look bellow)
    int[] inventory = RoomActivity.player.getInventory();                   //
    ArrayList <Equipment> totalInventory = new ArrayList<>();               //Compiled list of inventory and equipped items

    int itemType = InventoryActivity.itemToSwitch;;    // lets the class know what kind of item to switch
    RadioGroup listOfItems;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_switcher);
        setupItems(itemType);
    }

    public void onBackClick(View v){                //when player clicks back button
        if (v.getId() == R.id.backButton){
            Intent i = new Intent(ItemSwitcherActivity.this, InventoryActivity.class);
            startActivity(i);                       // goes back to inventory screen
        }
    }

    public void  setupItems(int t){                                             //gets the proper Radio buttons
        listOfItems = (RadioGroup) findViewById(R.id.inventoryList);            //The radio group displayed
                                                                                //
        for (int i = 0; i < equippedInventory.length; i++){                     //
            int ID = equippedInventory[i];                                      //
            Equipment e = new Equipment(ID);                                    //
            totalInventory.add(e);                                              //
        }                                                                       //
        for (int i = 0; i < inventory.length; i++){                             //
        int ID = inventory[i];                                                  //
            Equipment e = new Equipment(ID);                                    //
        totalInventory.add(e);                                                  //
        }                                                                       //here gets the players equipment into a one nice and easy to use ArrayList

        switch(t) {
            case (0):
                currentLocation = 0;
                currentID = (totalInventory.get(0)).getID();

                RadioButton helm = new RadioButton(this);
                String currentItemText;
                currentItemText = ("You have " + totalInventory.get(0).getText());
                helm.setText(currentItemText);
                helm.setChecked(true);
                listOfItems.addView(helm);
                for (int i = 0; i < (totalInventory.size() - 1); i++) {
                    if ((totalInventory.get(i).isHelmet) && !((totalInventory.get(i).getID()) == 0)) {
                        RadioButton RB = new RadioButton(this);
                        RB.setText(totalInventory.get(i).getText());
                        listOfItems.addView(RB);

                        switchToLocation.add(i);
                        switchToID.add((totalInventory.get(i)).getID());
                    }
                }
                if (totalInventory.get(0).getID() != 0) {
                    RadioButton unequip = new RadioButton(this);
                    unequip.setText("Unequip current item");
                }
                break;
            case (1):
                //do stuff
                break;
            case (2):
                //do stuff
                break;
            case (3):
                //do stuff
                break;
            case (4):
                //do stuff
                break;
            default:
                Intent i = new Intent(ItemSwitcherActivity.this, InventoryActivity.class);
                startActivity(i);
                break;
        }
    }

    public void onEquipButtonClick(View v){
        int switchto = (listOfItems.getCheckedRadioButtonId()-1);
        int tempID;
        boolean notEquipped = false;
        if(switchto >= (6)){
            notEquipped = true;
        }

        tempID = currentID;
        RoomActivity.player.equipment[currentLocation] = switchToID.get(switchto);

        if(notEquipped){
            RoomActivity.player.inventory[switchToLocation.get(switchto + 6)] = tempID;
        }
        else{
            RoomActivity.player.equipment[switchToLocation.get(switchto)] = tempID;
        }
        setupItems(itemType);
    }
}
