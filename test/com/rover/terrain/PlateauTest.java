package com.rover.terrain;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class PlateauTest extends Assert {

    private final Coordinate topRight = new Coordinate( 3, 3);
    private final Plateau plateau = new Plateau(topRight);
    private final Coordinate bottomLeft = new Coordinate(0 ,0);
    private final Coordinate topLeft = new Coordinate(0 ,3);
    private final Coordinate bottomRight = new Coordinate(3 ,0);

    @Test
    public void bottomLeftIsValid() {
        assertThat(plateau.isValidCoordinate(bottomLeft), is(true));
    }

    @Test
    public void bottomRightIsValid() {
        assertThat(plateau.isValidCoordinate(bottomRight), is(true));
    }

    @Test
    public void topLeftIsValid() {
        assertThat(plateau.isValidCoordinate(topLeft), is(true));
    }

    @Test
    public void topRightIsValid() {
        assertThat(plateau.isValidCoordinate(topRight), is(true));
    }
}
