package com.rover;

import com.rover.instruction.Instruction;
import com.rover.terrain.Coordinate;
import com.rover.terrain.Plateau;
import com.rover.terrain.Position;

import java.util.LinkedList;
import java.util.List;

import static com.rover.instruction.Instruction.MOVE;
import static com.rover.instruction.Instruction.TURN_LEFT;
import static com.rover.terrain.Heading.NORTH;

public class Main {

    public static void main(String[] args) {
        //String upperRight = "5 5";
        String rover1Start = "1 2 N";
        String rover1Instructions = "LMLMLMLMM";
        String expectedRover1Output = "1 3 N";

        Coordinate upperRight = new Coordinate(5, 5);
        Plateau plateau = new Plateau(upperRight);

        Coordinate roverStart = new Coordinate(1, 2);
        Position roverInitialPosition = new Position(roverStart, NORTH);
        Rover rover = new Rover(plateau, roverInitialPosition);

        List<Instruction> instructions = new LinkedList<Instruction>();
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
        System.out.println(journey.get(journey.size() - 1));
    }
}
