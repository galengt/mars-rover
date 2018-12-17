package com.rover.instruction;

import com.rover.Rover;

import java.util.function.Function;

public enum Instruction {

    TURN_RIGHT,
    TURN_LEFT,
    MOVE
    ;

    public void accept(Rover rover) {
        rover.visit(this);
    }

}
