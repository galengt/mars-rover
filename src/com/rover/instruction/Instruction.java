package com.rover.instruction;

import com.rover.terrain.Heading;

public enum Instruction {

    TURN_RIGHT,
    TURN_LEFT,
    MOVE
    ;

    public static Instruction parseInput(char input) {
        switch (input) {
            case 'L':
                return TURN_LEFT;
            case 'R':
                return TURN_RIGHT;
            case 'M':
                return MOVE;
            default:
                throw new IllegalArgumentException(String.format("Unknown heading input %s", input));
        }
    }
}
