package com.blogspot.darokrithia.dungeonfungeon;

import java.util.ArrayList;

/**
 * Created by Daniel Tabin on 12/10/15.
 */
public class Layout {
    int rows = 1;       //how many rows of rooms
    int columns = 1;    //how many columns of rooms

    ArrayList<ArrayList<Room>> roomsLayout = new ArrayList<>();

    public void assignID(Room r) {
        if(r.myRow == 0){
            r.roomID = 0;
        }
        else if (r.myRow == 1) {
            if(r.myColumn == 0){
                r.roomID = 0;
            }
            else if (r.myColumn == 1){
                r.roomID = 1;
            }
            else if (r.myColumn == 2){
                r.roomID = 2;
                r.roomState = 1;
            }
            else if (r.myColumn == 3){
                r.roomID = 1;
            }
            else if (r.myColumn == 4){
                r.roomID = 0;
            }
            else{
                r.roomID = 0;
            }
        }
        else if (r.myRow == 2) {
            if(r.myColumn == 0){
                r.roomID = 0;
            }
            else if (r.myColumn == 1) {
                r.roomID = 2;
                r.roomState = 1;
            }
            else if (r.myColumn == 2){
                r.roomID = 1;
            }
            else if (r.myColumn == 3) {
                r.roomID = 2;
                r.roomState = 1;
            }
            else if (r.myColumn == 4){
                r.roomID = 0;
            }
            else{
                r.roomID = 0;
            }
        }
        else if (r.myRow == 3) {
            if(r.myColumn == 0){
                r.roomID = 0;
            }
            else if (r.myColumn == 1){
                r.roomID = 1;
            }
            else if (r.myColumn == 2){
                r.roomID = 2;
                r.roomState = 1;
            }
            else if (r.myColumn == 3){
                r.roomID = 1;
            }
            else if (r.myColumn == 4){
                r.roomID = 0;
            }
            else{
                r.roomID = 0;
            }
        }
        else if (r.myRow == 4){
            r.roomID = 0;
        }
        else{
            r.roomID = 0;
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
