package com.rover.input;

import com.rover.instruction.Instruction;

import java.util.function.Function;

public class InstructionParser implements Function<String, Instruction> {

    @Override
    public Instruction apply(String input) {
        switch (input) {
            case "L":
                return Instruction.TURN_LEFT;
            case "R":
                return Instruction.TURN_RIGHT;
            case "M":
                return Instruction.MOVE;
            default:
                throw new IllegalArgumentException(String.format("Unknown heading input %s", input));
        }
    }
}
