package com.rover.terrain;

public class Plateau {

    private final Coordinate upperRight;

    public Plateau(Coordinate upperRight) {
        this.upperRight = upperRight;
    }

    public boolean isValidCoordinate(Coordinate coordinate) {
        if (coordinate.getXPos() > this.upperRight.getXPos() ||
            coordinate.getYPos() > this.upperRight.getYPos()) {
            return false;
        }
        return true;
    }
}
