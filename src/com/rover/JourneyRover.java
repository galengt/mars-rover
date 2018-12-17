package com.rover;

import com.rover.instruction.Instruction;
import com.rover.terrain.Position;
import com.rover.terrain.Plateau;

import java.util.LinkedList;
import java.util.List;

public class JourneyRover implements Rover<Journey> {

    private final Plateau plateau;
    private final LinkedList<Position> positions = new LinkedList<>();

    JourneyRover(Plateau plateau, Position initialPosition) {
        this.plateau = plateau;
        this.positions.add(initialPosition);
    }

    @Override
    public void visit(Instruction instruction) {
        Position newPosition = getNewPosition(positions.peekLast(), instruction);
        if (plateau.isValidCoordinate(newPosition.getCoordinate())) {
            positions.add(newPosition);
        } else {
            throw new IllegalStateException(
                String.format("Instruction %s would move us to invalid coordinate %s", instruction, newPosition.getCoordinate()));
        }
    }

    @Override
    public Journey executeInstructions(Iterable<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            instruction.accept(this);
        }
        return new Journey(positions);
    }

    //TODO how to add new instructions?
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
