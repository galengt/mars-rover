package com.rover;

import com.rover.instruction.Instruction;
import com.rover.terrain.Coordinate;
import com.rover.terrain.Heading;
import com.rover.terrain.Plateau;
import com.rover.terrain.Position;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        parseInputs();
    }

    private static Map<Rover, List<Instruction>> parseInputs() {
        try (Scanner scanner = new Scanner(new FileReader("resources/Input.txt"))) {
            Coordinate upperRight = new Coordinate(scanner.nextInt(), scanner.nextInt());
            Plateau plateau = new Plateau(upperRight);
            scanner.nextLine(); //burn rest of the line
            Rover rover = null;
            while(scanner.hasNextLine()) {
                if (rover == null) {
                    rover = parseRoverLine(scanner, plateau);
                } else {
                    List<Instruction> instructions = parseInstructionLine(scanner);
                    System.out.println(rover.calculateJourney(instructions).getFinalPosition());
                    rover = null;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Rover parseRoverLine(Scanner scanner, Plateau plateau) {
        Coordinate roverStart = new Coordinate(scanner.nextInt(), scanner.nextInt());
        Heading initialHeading = Heading.parseInput(scanner.next().charAt(0));
        scanner.nextLine();
        return new Rover(plateau, new Position(roverStart, initialHeading));
    }

    private static List<Instruction> parseInstructionLine(Scanner scanner) {
        String[] rawInstructions = scanner.nextLine().split("");
        List<Instruction> instructions = new LinkedList<>();
        for (int i = 0; i < rawInstructions.length; i++) {
            instructions.add(Instruction.parseInput(rawInstructions[i].charAt(0)));
        }
        return instructions;
    }
}
