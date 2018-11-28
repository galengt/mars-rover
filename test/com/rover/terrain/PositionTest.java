package com.rover.terrain;

import static com.rover.terrain.Heading.EAST;
import static com.rover.terrain.Heading.NORTH;
import static com.rover.terrain.Heading.WEST;

public class PositionTest { //extends Assert {

    Position pos = new Position(
        new Coordinate(1, 1),
        NORTH);

    /*public void turnRightIsHeadingEast() {
        Position newPos = pos.turnRight();
        assertThat(newPos.getHeading(), is(EAST));
        assertThat(newPos.getCoordinate().getXPos(), is(1));
        assertThat(newPos.getCoordinate().getYPos(), is(1));
    }

    public void turnLeftIsHeadingWst() {
        Position newPos = pos.turnLeft();
        assertThat(newPos.getHeading(), is(WEST));
        assertThat(newPos.getCoordinate().getXPos(), is(1));
        assertThat(newPos.getCoordinate().getYPos(), is(1));
    }

    public void moveIncreasesY() {
        Position newPos = pos.move();
        assertThat(newPos.getHeading(), is(NORTH));
        assertThat(newPos.getCoordinate().getXPos(), is(1));
        assertThat(newPos.getCoordinate().getYPos(), is(2));
    }*/
}
