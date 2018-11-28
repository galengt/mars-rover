package com.rover.terrain;

import org.junit.Assert;
import org.junit.Test;

import static com.rover.terrain.Heading.EAST;
import static com.rover.terrain.Heading.NORTH;
import static com.rover.terrain.Heading.SOUTH;
import static com.rover.terrain.Heading.WEST;
import static org.hamcrest.core.Is.is;

public class CoordinateTest extends Assert {

    public void negativeXTest() {
        new Coordinate(-1, 1);
    }

    public void negativeYTest() {
        new Coordinate(1, -1);
    }

    Coordinate coord = new Coordinate(1, 1);

    @Test
    public void moveNorthIncreasesY() {
        Coordinate newCoordinate = coord.move(NORTH);
        assertThat(newCoordinate.getXPos(), is(1));
        assertThat(newCoordinate.getYPos(), is(2));
    }

    @Test
    public void moveEastIncreasesX() {
        Coordinate newCoordinate = coord.move(EAST);
        assertThat(newCoordinate.getXPos(), is(2));
        assertThat(newCoordinate.getYPos(), is(1));
    }

    @Test
    public void moveSouthDecreasesY() {
        Coordinate newCoordinate = coord.move(SOUTH);
        assertThat(newCoordinate.getXPos(), is(1));
        assertThat(newCoordinate.getYPos(), is(0));
    }

    @Test
    public void moveWestDecreasesX() {
        Coordinate newCoordinate = coord.move(WEST);
        assertThat(newCoordinate.getXPos(), is(0));
        assertThat(newCoordinate.getYPos(), is(1));
    }
}
