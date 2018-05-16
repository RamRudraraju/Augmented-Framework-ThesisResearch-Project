package com.example.rrkr2016.javaclassname;

/**
 * Created by RRKR2016 on 10/17/2017.
 */

public class RoomReservation implements Resource {

    public String getName(){
        return "Room Reservation";
    }

    public String getHorD(){
        return "H";
    }

    public String getUniqueIdentifier() {
        return "1";
    }

    public String[][] getResourceMatrix() {
        String[][] resourceGrid = {
                {"Projectors Borrow","D","","","","","","","","",},
                {"Projector Name","A","SM","SD","SY","EM","ED","EY","ST","ET"},
                {"RM 101","1","0.1","0.1","0.1","0.1","0.1","0.1","0.1","0.1"},
                {"RM 102","1","0.1","0.1","0.1","0.1","0.1","0.1","0.1","0.1"},
                {"RM 201","1","0.1","0.1","0.1","0.1","0.1","0.1","0.1","0.1"},
                {"RM 202","1","0.1","0.1","0.1","0.1","0.1","0.1","0.1","0.1"}
        };
        return resourceGrid;
    }

    public  String getInputClassName(){
        return  "RoomReservation";
    }

    public  String timePeriod(){
        return  "3";
    }

}

