package com.rover;

import com.rover.instruction.Instruction;
import com.rover.input.InstructionParser;
import com.rover.terrain.Coordinate;
import com.rover.terrain.Heading;
import com.rover.terrain.Plateau;
import com.rover.terrain.Position;

import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        parseInputs();
    }

    private static Map<JourneyRover, List<Instruction>> parseInputs() {
//        try {
//            Files.lines(Paths.get("resources/Input.txt"))
//                .forEach(new Foo());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

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
                    rover.executeInstructions(instructions);
                    rover = null;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

//    private static class Foo implements Consumer<String> {
//        JourneyRover rover = null;
//
//        public Foo(Plateau plateau) {
//            this.rover = rover;
//        }
//
//        @Override
//        public void accept(String s) {
//            if (rover == null) {
//                rover = parseRoverLine(scanner, plateau);
//            } else {
//                List<Instruction> instructions = parseInstructionLine(scanner);
//                System.out.println(rover.executeInstructions(instructions).getFinalPosition());
//                rover = null;
//            }
//    }

    private static JourneyRover parseRoverLine(Scanner scanner, Plateau plateau) {
        Coordinate roverStart = new Coordinate(scanner.nextInt(), scanner.nextInt());
        Heading initialHeading = Heading.parseInput(scanner.next());
        scanner.nextLine();
        return new JourneyRover(plateau, new Position(roverStart, initialHeading));
    }

    private static List<Instruction> parseInstructionLine(Scanner scanner) {
        List<Instruction> instructions = Stream.of(scanner.nextLine().split(""))
            .map(new InstructionParser())
            .collect(Collectors.toList());
        return instructions;
    }
}
