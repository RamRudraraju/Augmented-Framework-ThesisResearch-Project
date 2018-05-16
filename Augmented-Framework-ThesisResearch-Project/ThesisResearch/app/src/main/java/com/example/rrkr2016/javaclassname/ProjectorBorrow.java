package com.example.rrkr2016.javaclassname;

/**
 * Created by RRKR2016 on 10/17/2017.
 */

public class ProjectorBorrow implements Resource {

    public String getName(){
        return "Projectors Borrow";
    }

    public String getUniqueIdentifier() {
        return "2";
    }

    public String getHorD(){
        return "D";
    }

    public String[][] getResourceMatrix() {
        String[][] resourceGrid = {
                {"Projectors Borrow","D","","","","","","","","",},
                {"Projector Name","A","SM","SD","SY","EM","ED","EY","ST","ET"},
                {"Leon","2","0.1","0.1","0.1","0.1","0.1","0.1","0.1","0.1"},
                {"Dell 712","2","0.1","0.1","0.1","0.1","0.1","0.1","0.1","0.1"},
                {"Apple 512","2","0.1","0.1","0.1","0.1","0.1","0.1","0.1","0.1"},
        };
        return resourceGrid;
    }
    public  String getInputClassName(){
        return  "ProjectorReso";
    }

    public  String timePeriod(){
        return  "10";
    }

}
