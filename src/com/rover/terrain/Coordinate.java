package com.rover.terrain;

public class Coordinate {

    private final int xPos;
    private final int yPos;

    public Coordinate(int xPos, int yPos) {
        if (xPos < 0 || yPos < 0) {
            throw new IllegalStateException(
                String.format("Invalid coordinates with negative value [%s, %s]", xPos, yPos));
        }
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public int getXPos() {
        return this.xPos;
    }
    public int getYPos() {
        return this.yPos;
    }
    public Coordinate move(Heading heading) {
        switch (heading) {
            case NORTH:
                return new Coordinate(this.xPos, this.yPos + 1);
            case EAST:
                return new Coordinate(this.xPos + 1, this.yPos);
            case SOUTH:
                return new Coordinate(this.xPos, this.yPos - 1);
            case WEST:
                return new Coordinate(this.xPos - 1, this.yPos);
            default:
                throw new IllegalArgumentException(String.format("Unknown heading %s", heading));
        }
    }

    @Override
    public String toString() {
        return "Coordinate{" +
            this.xPos +
            ", " + this.yPos +
            '}';
    }
}
