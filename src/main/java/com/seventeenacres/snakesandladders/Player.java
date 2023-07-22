package com.seventeenacres.snakesandladders;

import java.util.Random;

public class Player {
    private int location = 0;
    private final int name;
    private int rollsToStart;
    private int totalRolls;
    public Player(int name){
        this.name=name;
    }
    public int getLocation() {
        return location;
    }
    public int getName() {
        return name;
    }
    public void setLocation(int destination) {
        location = destination;
    }
    private int rollDie(){
        int result = new Random().nextInt(6)+1;
        if(App.IS_VERBOSE)
            System.out.print("Player "+name+" rolled a "+String.valueOf(result));
        return result;
    }
    public void doTurn(){
        int dieResult = rollDie();
        totalRolls++;
        if(location==0){
            rollsToStart++;
            if(dieResult == 6){
                System.out.println(" Player "+name+" has entered the board!");
                location = 1;
            }
        }else{
            int targetSpot = location + dieResult;
            if(targetSpot>100){
                System.out.println(" Player "+name+" has bounced off the finish!");
                location = 100-(targetSpot-100);
            }else{
                location = targetSpot;
            }
        }
        Board.getInstance().handleThings(this);
        if(App.IS_VERBOSE)
            System.out.println(" Player "+name+" at "+String.valueOf(location));
        if(dieResult == 6 && location !=100){
            if(App.IS_VERBOSE)
                System.out.println("Player "+name+" going again!");
            doTurn();
        }
            
    }
    @Override
    public String toString(){
        return "Player "+name+" with "+String.valueOf(totalRolls)+" rolls overall, taking "+String.valueOf(rollsToStart)+" rolls to get on the board";
    }
    public String toCsv(){
        return name+","+String.valueOf(totalRolls)+","+String.valueOf(rollsToStart);
    }

}
