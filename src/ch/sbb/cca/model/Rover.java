package ch.sbb.cca.model;

public class Rover {
    int xCoord;
    int yCoord;
    String cardinalDirection;

    public Rover(int x, int y, String cardinalDirection){
        this.xCoord = x;
        this.yCoord = y;
        this.cardinalDirection = cardinalDirection;
    }
}
