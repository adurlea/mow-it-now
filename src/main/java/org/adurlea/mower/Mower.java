package org.adurlea.mower;

/**
 * Created by adurlea on 28/10/15.
 */
public class Mower {

    private Coordinate coordinate;
    private int xPos;
    private int yPos;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public String toString() {
        return xPos + " " + yPos + " " + coordinate.name();
    }
}
