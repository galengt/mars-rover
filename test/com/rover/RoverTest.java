package com.rover;

import com.rover.instruction.Instruction;
import com.rover.terrain.Coordinate;
import com.rover.terrain.Heading;
import com.rover.terrain.Plateau;
import com.rover.terrain.Position;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static com.rover.instruction.Instruction.MOVE;
import static com.rover.instruction.Instruction.TURN_LEFT;
import static com.rover.instruction.Instruction.TURN_RIGHT;
import static com.rover.terrain.Heading.EAST;
import static com.rover.terrain.Heading.NORTH;
import static com.rover.terrain.Heading.WEST;
import static org.hamcrest.core.Is.is;

public class RoverTest extends Assert {

    Coordinate upperRight;
    Plateau plateau;
    Coordinate roverStart;
    Position roverInitialPosition;
    List<Instruction> instructions = new LinkedList<Instruction>();


    private Rover setup(int upperRightX, int upperRightY, int roverStartX, int roverStartY, Heading roverStartHeading) {
        upperRight = new Coordinate(upperRightX, upperRightY);
        plateau = new Plateau(upperRight);

        roverStart = new Coordinate(roverStartX, roverStartY);
        roverInitialPosition = new Position(roverStart, roverStartHeading);
        return new Rover(plateau, roverInitialPosition);
    }

    @Test
    public void circleLeft() {
        Rover rover = setup(5, 5, 1,2, NORTH);
        instructions.add(TURN_LEFT);
        instructions.add(MOVE);
        instructions.add(TURN_LEFT);
        instructions.add(MOVE);
        instructions.add(TURN_LEFT);
        instructions.add(MOVE);
        instructions.add(TURN_LEFT);
        instructions.add(MOVE);
        instructions.add(MOVE);
        List<Position> journey = rover.calculateJourney(instructions);
        Position finalPosition = journey.get(journey.size() - 1);
        assertThat(finalPosition.getCoordinate().getXPos(), is(1));
        assertThat(finalPosition.getCoordinate().getYPos(), is(3));
        assertThat(finalPosition.getHeading(), is(NORTH));
    }

    @Test
    public void circleRight() {
        Rover rover = setup(5, 5, 3, 3, EAST);
        instructions = new LinkedList<Instruction>();
        instructions.add(MOVE);
        instructions.add(MOVE);
        instructions.add(TURN_RIGHT);
        instructions.add(MOVE);
        instructions.add(MOVE);
        instructions.add(TURN_RIGHT);
        instructions.add(MOVE);
        instructions.add(TURN_RIGHT);
        instructions.add(TURN_RIGHT);
        instructions.add(MOVE);
        List<Position> journey = rover.calculateJourney(instructions);
        Position finalPosition = journey.get(journey.size() - 1);
        assertThat(finalPosition.getCoordinate().getXPos(), is(5));
        assertThat(finalPosition.getCoordinate().getYPos(), is(1));
        assertThat(finalPosition.getHeading(), is(EAST));
    }

    @Test(expected = IllegalStateException.class)
    public void fallOffLeft() {
        Rover rover = setup(5, 5, 0, 0, WEST);
        instructions = new LinkedList<Instruction>();
        instructions.add(MOVE);
        rover.calculateJourney(instructions);
    }

    @Test(expected = IllegalStateException.class)
    public void fallOffTop() {
        Rover rover = setup(5, 5, 5, 5, EAST);
        instructions = new LinkedList<Instruction>();
        instructions.add(MOVE);
        rover.calculateJourney(instructions);
    }
}
