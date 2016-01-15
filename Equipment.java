package com.blogspot.darokrithia.dungeonfungeon;

/**
 * Created by dtabin17 on 1/12/16.
 */
public class Equipment {
    String name;
    String description;
    int ID = 0;

    boolean isHelmet;
    boolean isArmor;
    boolean isLeggings;
    boolean isBoots;
    boolean isWeapon;

    public void assignStats(){ // assigns stas based on the ID
        switch (ID){
            case 0:
                name = new String("Nothing");
                description = new String("You have nothing...");
                isHelmet = true;
                isArmor = true;
                isLeggings = true;
                isBoots = true;
                isWeapon = true;
                break;
            case 1:
                name = new String("Hat");
                description = new String("This is a hat");
                isHelmet = true;
                isArmor = false;
                isLeggings = false;
                isBoots = false;
                isWeapon = false;
            break;
            case 2:
                name = new String("Chestplate");
                description = new String("This is a chestplate");
                isHelmet = false;
                isArmor = true;
                isLeggings = false;
                isBoots = false;
                isWeapon = false;
            break;
            case 3:
                name = new String("Pants");
                description = new String("These are pants");
                isHelmet = false;
                isArmor = false;
                isLeggings = true;
                isBoots = false;
                isWeapon = false;
            break;
            case 4:
                name = new String("Shoes");
                description = new String("These are shoes");
                isHelmet = false;
                isArmor = false;
                isLeggings = false;
                isBoots = true;
                isWeapon = false;
            break;
            case 5:
                name = new String("Shield");
                description = new String("This is a shield");
                isHelmet = false;
                isArmor = false;
                isLeggings = false;
                isBoots = false;
                isWeapon = true;
            break;
            case 6:
                name = new String("Sword");
                description = new String("This is a sword");
                isHelmet = false;
                isArmor = false;
                isLeggings = false;
                isBoots = false;
                isWeapon = true;
            break;
            case 7:
                name = new String("Socs");
                description = new String("Also works as a make shift mask");
                isHelmet = true;
                isArmor = false;
                isLeggings = false;
                isBoots = true;
                isWeapon = false;
                break;
            default:
                name = new String("ERROR ITEM");
                description = new String("This is an ERROR 101101001010101");
                isHelmet = false;
                isArmor = false;
                isLeggings = false;
                isBoots = false;
                isWeapon = false;
            break;

        }
    }

    public Equipment(int id){
        ID = id;
        assignStats();
    }
}
