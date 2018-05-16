package com.example.rrkr2016.javaclassname;

/**
 * Created by RRKR2016 on 10/17/2017.
 */

public class BookBorrow implements Resource {

    public String getName(){
        return "Books Borrow";
    }

    public String getHorD(){
        return "D";
    }

    public String getUniqueIdentifier() {
        return "3";
    }

    public String[][] getResourceMatrix() {
        String[][] resourceGrid = {
                {"Book Borrow","D","","","","","","","","",},
                {"Book Name","A","SM","SD","SY","EM","ED","EY","ST","ET"},
                {"Book1","3","0.1","0.1","0.1","0.1","0.1","0.1","0.1","0.1"},
                {"Book2","3","0.1","0.1","0.1","0.1","0.1","0.1","0.1","0.1"},
                {"Book3","3","0.1","0.1","0.1","0.1","0.1","0.1","0.1","0.1"},
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