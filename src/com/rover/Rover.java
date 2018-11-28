package com.rover;

import com.rover.instruction.Instruction;
import com.rover.terrain.Position;
import com.rover.terrain.Plateau;

import java.util.LinkedList;
import java.util.List;

public class Rover {

    private final Plateau plateau;
    private final Position initialPosition;

    Rover(Plateau plateau, Position initialPosition) {
        this.plateau = plateau;
        this.initialPosition = initialPosition;
    }

    public Iterable<Position> calculateJourney(Iterable<Instruction> instructions) {
        LinkedList<Position> journey = new LinkedList<Position>();
        journey.add(initialPosition);
        for (Instruction instruction : instructions) {
            Position newPosition = getNewPosition(journey.peekLast(), instruction);
            if (plateau.isValidCoordinate(newPosition.getCoordinate())) {
                journey.add(newPosition);
            } else {
                throw new IllegalStateException(
                    String.format("Instruction %s would move us to invalid coordinate %s", instruction, newPosition.getCoordinate()));
            }
        }
        return journey;
    }

    private Position getNewPosition(Position currentPosition, Instruction instruction) {
        switch (instruction) {
            case TURN_LEFT:
                return currentPosition.turnLeft();
            case TURN_RIGHT:
                return currentPosition.turnRight();
            case MOVE:
                return currentPosition.move();
            default:
                throw new IllegalArgumentException(String.format("Unknown instruction %s", instruction));
        }
    }
}