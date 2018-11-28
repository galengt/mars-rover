package com.rover.terrain;

import org.junit.Assert;
import org.junit.Test;

import static com.rover.terrain.Heading.EAST;
import static com.rover.terrain.Heading.NORTH;
import static com.rover.terrain.Heading.SOUTH;
import static com.rover.terrain.Heading.WEST;
import static org.hamcrest.core.Is.is;

public class HeadingTest extends Assert {

    @Test
    public void northTurnLeftIsWest() {
        assertThat(NORTH.turnLeft(), is(WEST));
    }

    @Test
    public void northTurnRightIsEast() {
        assertThat(NORTH.turnRight(), is(EAST));
    }

    @Test
    public void eastTurnLeftIsNorth() {
        assertThat(EAST.turnLeft(), is(NORTH));
    }

    @Test
    public void eastTurnRightIsSouth() {
        assertThat(EAST.turnRight(), is(SOUTH));
    }

    @Test
    public void southTurnLeftIsEast() {
        assertThat(SOUTH.turnLeft(), is(EAST));
    }

    @Test
    public void southTurnRightIsWest() {
        assertThat(SOUTH.turnRight(), is(WEST));
    }

    @Test
    public void westTurnLeftIsSouth() {
        assertThat(WEST.turnLeft(), is(SOUTH));
    }

    @Test
    public void westTurnRightIsNorth() {
        assertThat(WEST.turnRight(), is(NORTH));
    }
}
