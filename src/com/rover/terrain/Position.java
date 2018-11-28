package com.rover.terrain;

public class Position {

    private final Coordinate coordinate;
    private final Heading heading;

    public Position(Coordinate coordinate, Heading heading) {
        this.coordinate = coordinate;
        this.heading = heading;
    }
    public Coordinate getCoordinate() {
        return this.coordinate;
    }
    public Heading getHeading() {
        return this.heading;
    }
    public Position turnRight() {
        return new Position(
            this.coordinate,
            this.heading.turnRight());
    }
    public Position turnLeft() {
        return new Position(
            this.coordinate,
            this.heading.turnLeft());
    }
    public Position move() {
        return new Position(
            this.coordinate.move(this.heading),
            this.heading);
    }

    @Override
    public String toString() {
        return "Position{" +
            this.coordinate +
            ", heading=" + this.heading +
            '}';
    }
}
