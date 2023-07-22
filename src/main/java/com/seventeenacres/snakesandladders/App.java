package com.seventeenacres.snakesandladders;

import java.util.ArrayList;

/**
 * Rules:
 * Must roll a 6 to get on the board
 * Can roll 3 times first time
 * Roll again if get a six
 * Can choose if ladders are snakes or vice versa
 * If you roll extra past 100, you walk backwards.
 */
public class App 
{
    static final OverlaidThing.ThingType OVERRIDE_THING_TYPE = OverlaidThing.ThingType.ORIGINAL;
    static final boolean IS_VERBOSE = false;
    static final boolean STOP_ON_WIN = false;
    static final int NUM_PLAYERS = 100;
    public static void main( String[] args )
    {
        ArrayList<Player> players = new ArrayList<>();
        for(int i=0;i<NUM_PLAYERS;i++)
            players.add(new Player(i));
        
        //Start Game
        for (Player player : players) {
            for(int i=0;i<3;i++){
                player.doTurn();
                if(player.getLocation()>0)//has started
                    break;
            }
        }

        while(true){
            boolean gameOver = false;
            for (Player player : players) {
                if(player.getLocation() != 100){
                    player.doTurn();

                    if(player.getLocation() == 100){
                        System.out.println("Player "+player.getName()+" has won!");
                        if(STOP_ON_WIN)
                            gameOver = true;
                        break;
                    } 
                }
               
            }
            if(!STOP_ON_WIN){
                if(players.stream().allMatch(player -> player.getLocation()==100))
                    gameOver = true;
            } 
            if(gameOver)
                break;
        }
        for (Player player : players) {
            System.out.println(player.toString());
        }
        System.out.println("Player,Total Rolls, Rolls To Start");
        for (Player player : players) {
            System.out.println(player.toCsv());
        }
        for (OverlaidThing thing : Board.getInstance().getOverlaidThings()) {
            System.out.println(thing.toString());
        }
        System.out.println("Type,Entrance, Exit, Hit Count Per, Space Delta Per");
        for (OverlaidThing thing : Board.getInstance().getOverlaidThings()) {
            System.out.println(thing.toCsv());
        }
    }
}
