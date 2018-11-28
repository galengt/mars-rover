package com.rover;

import com.rover.instruction.Instruction;
import com.rover.terrain.Coordinate;
import com.rover.terrain.Heading;
import com.rover.terrain.Plateau;
import com.rover.terrain.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.rover.instruction.Instruction.MOVE;
import static com.rover.instruction.Instruction.TURN_LEFT;
import static com.rover.terrain.Heading.NORTH;

public class Main {

    public static void main(String[] args) {
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

    private static Map<Rover, List<Instruction>> parseInputs() {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/Input.txt"))) {
            String topRight = br.readLine();
            String[] topRightCoords = topRight.split(" ");
            Coordinate upperRight = new Coordinate(Integer.parseInt(topRightCoords[0]), Integer.parseInt(topRightCoords[0]));
            Plateau plateau = new Plateau(upperRight);
            String line;
            Rover rover = null;
            while((line = br.readLine()) != null) {
                if (rover == null) {
                    String[] positionInput = line.split("");
                    Coordinate roverStart = new Coordinate(Integer.parseInt(positionInput[0]), Integer.parseInt(positionInput[0]));
                    Heading initialHeading = Heading.parseInput(positionInput[4].charAt(0));
                    rover = new Rover(plateau, new Position(roverStart, initialHeading));
                } else {
                    String[] rawInstructions = line.split("");
                    List<Instruction> instructions = new LinkedList<Instruction>();
                    for (int i = 0; i < rawInstructions.length; i++) {
                        instructions.add(Instruction.parseInput(rawInstructions[i].charAt(0)));
                    }
                    List<Position> journey = rover.calculateJourney(instructions);
                    System.out.println(journey.get(journey.size() - 1));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
