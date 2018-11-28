package com.rover.terrain;

import org.junit.Assert;
import org.junit.Test;

import static com.rover.terrain.Heading.EAST;
import static com.rover.terrain.Heading.NORTH;
import static com.rover.terrain.Heading.WEST;
import static org.hamcrest.core.Is.is;

public class PositionTest extends Assert {

    Position pos = new Position(
        new Coordinate(1, 1),
        NORTH);

    @Test
    public void turnRightIsHeadingEast() {
        Position newPos = pos.turnRight();
        assertThat(newPos.getHeading(), is(EAST));
        assertThat(newPos.getCoordinate().getXPos(), is(1));
        assertThat(newPos.getCoordinate().getYPos(), is(1));
    }

    @Test
    public void turnLeftIsHeadingWst() {
        Position newPos = pos.turnLeft();
        assertThat(newPos.getHeading(), is(WEST));
        assertThat(newPos.getCoordinate().getXPos(), is(1));
        assertThat(newPos.getCoordinate().getYPos(), is(1));
    }

    @Test
    public void moveIncreasesY() {
        Position newPos = pos.move();
        assertThat(newPos.getHeading(), is(NORTH));
        assertThat(newPos.getCoordinate().getXPos(), is(1));
        assertThat(newPos.getCoordinate().getYPos(), is(2));
    }
}
