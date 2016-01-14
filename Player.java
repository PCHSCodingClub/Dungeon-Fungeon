package com.blogspot.darokrithia.dungeonfungeon;


/**
 * Created by dtabin17 on 1/9/16.
 */
public class Player {
    String name = "Nobody";
    int currentHP = 1;
    int maxHP =1;
    int baseSpeed = 1;
    int defence = 1;
    int attack = 1;
    int intelligence = 1;

    int[] equpiment = new int[]{    // list of the player's equipment ID
        0,                          // headgear ID
        0,                          // the body armor ID
        0,                          // the right hand gear ID
        0,                          // the left hang gear ID
        0,                          // the leg gear ID
        0,                          // the foot gear ID
        0,                          // the right weapon ID
        0,                          // the left weapon ID
    };
    int [] inventory = new int[]{
        0,  0,  0,  0,
        0,  0,  0,  0
    };




    Player(String n){
        name = n;
        maxHP = 20;
        currentHP = maxHP;
        baseSpeed = 10;
        defence = 5;
        attack = 10;
        intelligence = 10;
    }
    Player(String n, int h, int s, int d, int a, int i){
        name = n;
        maxHP = h;
        currentHP = maxHP;
        baseSpeed = s;
        defence = d;
        attack = a;
        intelligence = i;
    }

}