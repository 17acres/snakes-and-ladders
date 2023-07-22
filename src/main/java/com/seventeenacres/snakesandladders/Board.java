package com.seventeenacres.snakesandladders;

import java.util.ArrayList;

public class Board {
    //https://statelywarrenmanor.blogspot.com/2011/08/chutes-and-ladders.html
    
    private static Board instance;
    public static Board getInstance(){
        if(instance == null)
            instance = new Board();
        return instance;
    }
    private static final ArrayList<OverlaidThing> things;
    static{
        things = new ArrayList<>();
        //things.add(new OverlaidThing(1,38, OverlaidThing.ThingType.LADDER));
        things.add(new OverlaidThing(8,26, OverlaidThing.ThingType.LADDER));
        things.add(new OverlaidThing(19,38, OverlaidThing.ThingType.LADDER));
        things.add(new OverlaidThing(21,82, OverlaidThing.ThingType.LADDER));
        things.add(new OverlaidThing(28,53, OverlaidThing.ThingType.LADDER));
        things.add(new OverlaidThing(36,57, OverlaidThing.ThingType.LADDER));
        things.add(new OverlaidThing(50,91, OverlaidThing.ThingType.LADDER));
        things.add(new OverlaidThing(54,88, OverlaidThing.ThingType.LADDER));
        things.add(new OverlaidThing(62,96, OverlaidThing.ThingType.LADDER));
        things.add(new OverlaidThing(66,87, OverlaidThing.ThingType.LADDER));
        things.add(new OverlaidThing(80,99, OverlaidThing.ThingType.LADDER));
        things.add(new OverlaidThing(2,68, OverlaidThing.ThingType.SNAKE));
        things.add(new OverlaidThing(9,48, OverlaidThing.ThingType.SNAKE));
        things.add(new OverlaidThing(11,52, OverlaidThing.ThingType.SNAKE));
        things.add(new OverlaidThing(13,98, OverlaidThing.ThingType.SNAKE));
        things.add(new OverlaidThing(15,46, OverlaidThing.ThingType.SNAKE));
        things.add(new OverlaidThing(18,59, OverlaidThing.ThingType.SNAKE));
        things.add(new OverlaidThing(22,83, OverlaidThing.ThingType.SNAKE));
        things.add(new OverlaidThing(22,44, OverlaidThing.ThingType.SNAKE));
        things.add(new OverlaidThing(24,64, OverlaidThing.ThingType.SNAKE));
        things.add(new OverlaidThing(33,69, OverlaidThing.ThingType.SNAKE));
        things.add(new OverlaidThing(37,95, OverlaidThing.ThingType.SNAKE));
        things.add(new OverlaidThing(51,92, OverlaidThing.ThingType.SNAKE));
    } 
    public void handleThings(Player player){
        for (OverlaidThing overlaidThing : things) {
            if(overlaidThing.isEntering(player.getLocation())){
                if(App.IS_VERBOSE)
                    System.out.println("Player "+player.getName()+" entering "+overlaidThing.toString());
                player.setLocation(overlaidThing.getDestination());
            }
        }
    }
    public ArrayList<OverlaidThing> getOverlaidThings() {
        return things;
    }
}
