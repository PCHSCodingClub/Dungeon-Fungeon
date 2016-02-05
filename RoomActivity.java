package com.blogspot.darokrithia.dungeonfungeon;

/**
 * Created by Daniel Tabin on 12/10/15.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RoomActivity extends AppCompatActivity {
    static int row = 1;            //current row of room
    static int column = 1;         //current column of room
    static int totalRows = 5;      //total number of rows (including blank rooms)
    static int totalColumns = 5;   //total number of columns (including blank rooms)
    static Layout dungeon = new Layout(totalRows,totalColumns);    //Layout of this
    static Room currentRoom = dungeon.getRoom(row,column);         //The rooms the player is in
    public static Player player;                                   //The player


    @Override
    protected void onCreate(Bundle savedInstanceState) {  // No fucking idea what this does, but android studio seems to need it.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        currentRoom = dungeon.getRoom(row,column);
        setRoomText();
    }

    public void inventoryButtonClick(View v){
        if(v.getId() == R.id.inventory_button){
            Intent i = new Intent (RoomActivity.this, InventoryActivity.class);
            startActivity(i);
        }
    }

    public void aButtonClick(View v){
        if (v.getId() == R.id.AButton){
            dungeon.optionA(currentRoom);
            setRoomText();
        }
    }
    public void bButtonClick(View v){
        if (v.getId() == R.id.BButton){
            dungeon.optionB(currentRoom);
            setRoomText();
        }
    }
    public void cButtonClick(View v){
        if (v.getId() == R.id.CButton){
            dungeon.optionC(currentRoom);
            setRoomText();
        }
    }
    public void dButtonClick(View v){
        if (v.getId() == R.id.DButton){
            dungeon.optionD(currentRoom);
            setRoomText();
        }
    }

    public void setRoomText(){
        TextView roomText = (TextView) findViewById(R.id.RoomDescriptionText);    //What the room says
        TextView aOption = (TextView) findViewById(R.id.AOptionText);     //What option a does right now
        TextView bOption = (TextView) findViewById(R.id.BOptionText);     //What option b does right now
        TextView cOption = (TextView) findViewById(R.id.COptionText);     //What option c does right now
        TextView dOption = (TextView) findViewById(R.id.DOptionText);     //What option d does right now

        if (currentRoom.roomID == 0) {
            roomText.setText("WAIT WHAT!???\nSomething went terribly wrong.\n  This is supposed to be a wall, but either I messed up my code, or you are cheating.  There is nothing that can be done now, except for quitting.  Sorry for any inconvenience.  \n\n  EROROROEROEEROOREEROEOREOR 10100101011001010100101100101\n]n1100100110010101001!!!");
            aOption.setText("Press a to quit");
            bOption.setText("Press b to quit");
            cOption.setText("Press c to quit");
            dOption.setText("Press d to quit");
        } else if (currentRoom.roomID == 1) {
            roomText.setText("Welcome to room #1 " + player.name + "!\n  This is a test.  I hope this test is enjoyable for you.  Please come back later to play the full game!  Carry on now.");
            if (canMove(1)) {
                aOption.setText("Press a to move North");
            } else {
                aOption.setText("");
            }
            if (canMove(2)) {
                bOption.setText("Press b to move East");
            }
            else {
                bOption.setText("");
            }
            if (canMove(3)) {
                cOption.setText("Press c to move West");
            }
            else {
                cOption.setText("");
            }
            if (canMove(4)){
                dOption.setText("Press d to move South");
            }
            else{
                dOption.setText("");
            }
        } else if (currentRoom.roomID == 2) {
            if (currentRoom.roomState == 1) {
                roomText.setText("Welcome to room #2! \n Oh no! This room hasn't been cleared yet.  You need to clear it before you can move on.  You need to kill the evil orc monster right now!  Hurry up before it eats you! \n Just kidding, you can't lose in this game yet.  \n YET.");
                aOption.setText("Press a to kill the monster with your sword!");
                bOption.setText("Press b to make friends with the monster");
                cOption.setText("Press c to make a trap for the monster");
                dOption.setText("Press d to challenge to monster to rap + dance battle");
            } else {
                roomText.setText("Welcome back to room #2! \n Congrats!  You cleared the room.  Or at least you should have.  If you haven't cleared it then something went wrong.  Anyway, you now can move around the dungeon freely \n cya later");
                if (canMove(1)) {
                    aOption.setText("Press a to move North");
                } else {
                    aOption.setText("");
                }
                if (canMove(2)) {
                    bOption.setText("Press b to move East");
                }
                else {
                    bOption.setText("");
                }
                if (canMove(3)) {
                    cOption.setText("Press c to move West");
                }
                else {
                    cOption.setText("");
                }
                if (canMove(4)){
                    dOption.setText("Press d to move South");
                }
                else{
                    dOption.setText("");
                }
            }
        } else {
            roomText.setText("WAIT WHAT!???\nSomething went terribly wrong.  I don't know if this is your fault or mine, but you aren't supposed to be here.\n  REALLY!  This isn't part of the game.  This room doens't even have a proper ID set up.\n\n  EROROROEROEEROOREEROEOREOR 10100101011001010100101100101\n]n1100100110010101001!!!");
            aOption.setText("Press a to quit");
            bOption.setText("Press b to quit");
            cOption.setText("Press c to quit");
            dOption.setText("Press d to quit");
        }
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public static boolean canMove(int direction){      //makes sure there is no zero room (A wall / blank room) in the direction you want to go
        Room testRoom;
        switch (direction){
            case 1:
                testRoom = dungeon.getRoom((row-1),column);
                if(testRoom.getRoomID() == 0){
                    return false;
                }
                else{
                    return true;
                }
            case 2:
                testRoom = dungeon.getRoom(row,(column-1));
                if(testRoom.getRoomID() == 0){
                    return false;
                }
                else{
                    return true;
                }
            case 3:
                testRoom = dungeon.getRoom(row,(column+1));
                if(testRoom.getRoomID() == 0){
                    return false;
                }
                else{
                    return true;
                }
            case 4:
                testRoom = dungeon.getRoom((row+1),column);
                if(testRoom.getRoomID() == 0){
                    return false;
                }
                else{
                    return true;
                }
            default:
                return false;
        }
    }

    public static void moveNorth(){    //moves up one row
        if(canMove(1)){
            row -= 1;
            currentRoom = dungeon.getRoom(row, column);
        }
    }
    public static void moveEast(){     //moves across one column
        if(canMove(2)){
            column -= 1;
            currentRoom = dungeon.getRoom(row,column);
        }
    }
    public static void moveWest(){     //moves back one column
        if(canMove(3)){
            column += 1;
            currentRoom = dungeon.getRoom(row,column);
        }
    }
    public static void moveSouth(){    //moves down one row
        if(canMove(4)){
            row += 1;
            currentRoom = dungeon.getRoom(row,column);
        }
    }


}
