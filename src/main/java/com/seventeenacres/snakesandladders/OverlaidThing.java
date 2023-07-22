package com.seventeenacres.snakesandladders;

public class OverlaidThing{
    public enum ThingType{
        SNAKE,LADDER, ORIGINAL
    }
    private final int lowerEnd;
    private final int higherEnd;
    private int hitCount;
    private int spaceDelta;
    private final ThingType type;
    private final ThingType originalType;
    public OverlaidThing(int lowerEnd, int higherEnd, ThingType type){
        this.lowerEnd=lowerEnd;
        this.higherEnd=higherEnd;
        this.originalType = type;
        if(App.OVERRIDE_THING_TYPE == ThingType.ORIGINAL)
            this.type=type;
        else
            this.type = App.OVERRIDE_THING_TYPE;
    }
    public boolean isEntering(int pieceSpace){
        int spaceToLookAt;
        if(type == ThingType.SNAKE)
            spaceToLookAt = higherEnd;
        else
            spaceToLookAt = lowerEnd;
        if(pieceSpace == spaceToLookAt){
            hitCount++;
            if(type == ThingType.SNAKE)
                spaceDelta-=(higherEnd-lowerEnd);
            else
                spaceDelta+=(higherEnd-lowerEnd);
            return true;
        }
            
        return false;
    }

    public int getDestination(){
        if(type == ThingType.SNAKE)
            return lowerEnd;
        else
            return higherEnd;
    }
    public ThingType getType(){
        return type;
    }
    @Override
    public String toString(){
        if(type == ThingType.LADDER)
            return "LADDER (originally " + originalType.name() +") "+this.lowerEnd+">"+this.higherEnd+"Hit "+hitCount+" times, with a total delta spaces of "+spaceDelta;
        else
            return "SNAKE (originally " + originalType.name() +") "+this.higherEnd+">"+this.lowerEnd+"Hit "+hitCount+" times, with a total delta spaces of "+spaceDelta;
    }
    public String toCsv(){
        if(type == ThingType.LADDER)
            return "LADDER (originally " + originalType.name() +"),"+this.lowerEnd+","+this.higherEnd+","+(double)hitCount/(double)App.NUM_PLAYERS+","+(double)spaceDelta/(double)App.NUM_PLAYERS;
        else
            return "SNAKE (originally " + originalType.name() +"),"+this.higherEnd+","+this.lowerEnd+","+(double)hitCount/(double)App.NUM_PLAYERS+","+(double)spaceDelta/(double)App.NUM_PLAYERS;
    }
}
