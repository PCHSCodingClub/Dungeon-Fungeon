package com.blogspot.darokrithia.dungeonfungeon;

import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by Daniel Tabin on 12/10/15.
 */
public class Layout {
    int rows = 1;       //how many rows of rooms
    int columns = 1;    //how many columns of rooms

    int[] row0 = {
            0,0,0,0,0
    };
    int[] row1 = {
            0,1,2,1,0
    };
    int[] row2 = {
            0,2,3,2,0
    };
    int[] row3 = {
            0,1,2,1,0
    };
    int[] row4 = {
            0,0,0,0,0
    };
    int[][] grid = {
            row0,
            row1,
            row2,
            row3,
            row4
    };

    ArrayList<ArrayList<Room>> roomsLayout = new ArrayList<>();

    public void assignID(Room r) {
        int ID;
        int row;
        int column;

        row = r.myRow;
        column = r.myColumn;

        ID = grid[row][column];

        r.roomID = ID;
        if(ID == 2){
            r.roomState = 1;
        }
        if(ID == 3){
            r.roomState = 1;
        }
    }
    public void fill(){     //fills array lists with rooms
        for(int i = 0; i < rows; i++){
            ArrayList<Room> row = new ArrayList<>();
            for(int j = 0; j < columns; j++){
                Room cell = new Room(i,j,0);
                assignID(cell);
                row.add(cell);
            }
            roomsLayout.add(row);
        }
    }
    public ArrayList getLayout(){
        return roomsLayout;
    }

    public Room getRoom(int r, int c){      //returns room at a location
        ArrayList<Room> RoomList = roomsLayout.get(r);
        Room returnRoom = RoomList.get(c);
        return returnRoom;
    }

    public static void optionA(Room room){      //what happens when A is pressed
        if (room.roomID == 1){
            RoomActivity.moveNorth();
        }
        else if (room.roomID == 2){
            if (room.roomState == 1){
                room.roomState = 2;
                return;
            }
            else{
                RoomActivity.moveNorth();
            }
        }
        else{
            System.exit(0);
        }
    }

    public static void optionB(Room room){      //what happens when B is pressed
        if (room.roomID == 1){
            RoomActivity.moveEast();
        }
        else if (room.roomID == 2){
            if (room.roomState == 1){
                room.roomState = 2;
                return;
            }
            else{
                RoomActivity.moveEast();
            }
        }
        else{
            System.exit(0);
        }
    }

    public static void optionC(Room room){      //what happens when C is pressed
        if (room.roomID == 1){
            RoomActivity.moveWest();
        }
        else if (room.roomID == 2){
            if (room.roomState == 1){
                room.roomState = 2;
                return;
            }
            else{
                RoomActivity.moveWest();
            }
        }
        else if (room.roomID == 3){
            if (room.roomState == 1){
                RoomActivity.goToShop();
            }
        }
        else{
            System.exit(0);
        }
    }

    public static void optionD(Room room){      //what happens when D is pressed
        if (room.roomID == 1){
            RoomActivity.moveSouth();
        }
        else if (room.roomID == 2){
            if (room.roomState == 1){
                room.roomState = 2;
                return;
            }
            else{
                RoomActivity.moveSouth();
            }
        }
        else{
            System.exit(0);
        }
    }

    public Layout(){
        this.fill();
    }
    public Layout(int r, int c){
        rows = r;
        columns = c;
        this.fill();
    }
}
