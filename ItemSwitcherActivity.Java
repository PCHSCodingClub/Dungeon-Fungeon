package com.blogspot.darokrithia.dungeonfungeon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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
    TextView currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_switcher);
        setupItems(itemType);
    }

    public void onBackClick(View v){                //when player clicks back button
        if (v.getId() == R.id.backButton){
            exitInventory();// goes back to inventory screen
        }
    }

    public void  setupItems(int t){                                             //gets the proper Radio buttons
        listOfItems = (RadioGroup) findViewById(R.id.inventoryList);            //The radio group displayed
        currentItem = (TextView) findViewById(R.id.currentItem);
                                                                                //
        for (int i = 0; i < equippedInventory.length; i++){                     //
            int ID = equippedInventory[i];                                      //
            Equipment e = new Equipment(ID);                                    //
            totalInventory.add(e);                                              //
        }                                                                       //
        for (int i = 0; i < inventory.length; i++){                             //
        int ID = inventory[i];                                                  //
            Equipment e = new Equipment(ID);                                    //
            totalInventory.add(e);                                              //
        }                                                                       //here gets the players equipment into a one nice and easy to use ArrayList
        String currentItemText;

        switch(t) {
            case (0):
                currentLocation = 0;
                currentID = (totalInventory.get(0)).getID();

                currentItemText = ("You have " + totalInventory.get(0).getText());
                currentItem.setText(currentItemText);
                for (int i = 0; i < totalInventory.size(); i++) {
                    if (((totalInventory.get(i).isHelmet) && !((totalInventory.get(i).getID()) == 0) && (i != 0))) {
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
                    listOfItems.addView(unequip);
                    switchToLocation.add(getEmptySlot());
                    switchToID.add(0);
                }
                break;
            case (1):
                currentLocation = 1;
                currentID = (totalInventory.get(1)).getID();

                currentItemText = ("You have " + totalInventory.get(1).getText());
                currentItem.setText(currentItemText);
                for (int i = 0; i < totalInventory.size(); i++) {
                    if (((totalInventory.get(i).isArmor) && !((totalInventory.get(i).getID()) == 0) && (i != 1))) {
                        RadioButton RB = new RadioButton(this);
                        RB.setText(totalInventory.get(i).getText());
                        listOfItems.addView(RB);

                        switchToLocation.add(i);
                        switchToID.add((totalInventory.get(i)).getID());
                    }
                }
                if (totalInventory.get(1).getID() != 0) {
                    RadioButton unequip = new RadioButton(this);
                    unequip.setText("Unequip current item");
                    listOfItems.addView(unequip);
                    switchToLocation.add(getEmptySlot());
                    switchToID.add(0);
                }
                break;
            case (2):
                currentLocation = 2;
                currentID = (totalInventory.get(2)).getID();

                currentItemText = ("You have " + totalInventory.get(2).getText());
                currentItem.setText(currentItemText);
                for (int i = 0; i < totalInventory.size(); i++) {
                    if (((totalInventory.get(i).isLeggings) && !((totalInventory.get(i).getID()) == 0) && (i != 2))) {
                        RadioButton RB = new RadioButton(this);
                        RB.setText(totalInventory.get(i).getText());
                        listOfItems.addView(RB);

                        switchToLocation.add(i);
                        switchToID.add((totalInventory.get(i)).getID());
                    }
                }
                if (totalInventory.get(2).getID() != 0) {
                    RadioButton unequip = new RadioButton(this);
                    unequip.setText("Unequip current item");
                    listOfItems.addView(unequip);
                    switchToLocation.add(getEmptySlot());
                    switchToID.add(0);
                }
                break;
            case (3):
                currentLocation = 3;
                currentID = (totalInventory.get(3)).getID();

                currentItemText = ("You have " + totalInventory.get(3).getText());
                currentItem.setText(currentItemText);
                for (int i = 0; i < totalInventory.size(); i++) {
                    if (((totalInventory.get(i).isBoots) && !((totalInventory.get(i).getID()) == 0) && (i != 3))) {
                        RadioButton RB = new RadioButton(this);
                        RB.setText(totalInventory.get(i).getText());
                        listOfItems.addView(RB);

                        switchToLocation.add(i);
                        switchToID.add((totalInventory.get(i)).getID());
                    }
                }
                if (totalInventory.get(3).getID() != 0) {
                    RadioButton unequip = new RadioButton(this);
                    unequip.setText("Unequip current item");
                    listOfItems.addView(unequip);
                    switchToLocation.add(getEmptySlot());
                    switchToID.add(0);
                }
                break;
            case (4):
                currentLocation = 4;
                currentID = (totalInventory.get(4)).getID();

                currentItemText = ("You have " + totalInventory.get(4).getText());
                currentItem.setText(currentItemText);
                for (int i = 0; i < totalInventory.size(); i++) {
                    if (((totalInventory.get(i).isWeapon) && !((totalInventory.get(i).getID()) == 0) && (i != 4))) {
                        RadioButton RB = new RadioButton(this);
                        RB.setText(totalInventory.get(i).getText());
                        listOfItems.addView(RB);

                        switchToLocation.add(i);
                        switchToID.add((totalInventory.get(i)).getID());
                    }
                }
                if (totalInventory.get(4).getID() != 0) {
                    RadioButton unequip = new RadioButton(this);
                    unequip.setText("Unequip current item");
                    listOfItems.addView(unequip);
                    switchToLocation.add(getEmptySlot());
                    switchToID.add(0);
                }
                break;
            default:
                Intent i = new Intent(ItemSwitcherActivity.this, InventoryActivity.class);
                startActivity(i);
                break;
        }
    }
    public int getEmptySlot(){
        for (int i = 6; i < totalInventory.size(); i++){
            if(totalInventory.get(i).getID() == 0){
                return i;
            }
        }
        return -1;
    }
    public void onEquipButtonClick(View v){
        checkIfValidReplacement();

        if(listOfItems.getCheckedRadioButtonId() != -1) {
            int switchTo = ((listOfItems.indexOfChild(listOfItems.findViewById(listOfItems.getCheckedRadioButtonId()))));
            int tempID;
            boolean equipped = true;
            if (switchToLocation.get(switchTo) >= (6)) {
                equipped = false;
            }

            tempID = currentID;
            RoomActivity.player.equipment[currentLocation] = switchToID.get(switchTo);

            if (equipped) {
                RoomActivity.player.equipment[switchToLocation.get(switchTo)] = tempID;
            } else {
                RoomActivity.player.inventory[switchToLocation.get(switchTo) - 6] = tempID;
            }
            switchToID.clear();
            switchToID.clear();
        }
        exitInventory();
    }
    public void checkIfValidReplacement(){
        int testThis = listOfItems.indexOfChild(listOfItems.findViewById(listOfItems.getCheckedRadioButtonId()));
        switch (itemType) {
            case (0):
                if (!(totalInventory.get(switchToID.get(testThis)).isHelmet)) {
                    exitInventory();
                }
                break;
            case (1):
                if (!(totalInventory.get(switchToID.get(testThis)).isArmor)) {
                    exitInventory();
                }
                break;
            case (2):
                if (!(totalInventory.get(switchToID.get(testThis)).isLeggings)) {
                    exitInventory();
                }
                break;
            case (3):
                if (!(totalInventory.get(switchToID.get(testThis)).isBoots)) {
                    exitInventory();
                }
                break;
            case (4):
                if (!(totalInventory.get(switchToID.get(testThis)).isWeapon)) {
                    exitInventory();
                }
                break;

        }
    }
    public void exitInventory(){
        Intent i = new Intent(ItemSwitcherActivity.this, InventoryActivity.class);
        startActivity(i);                       // goes back to inventory screen
    }
}
