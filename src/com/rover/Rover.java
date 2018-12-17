package com.rover;

import com.rover.instruction.Instruction;

public interface Rover<T> {

    void visit(Instruction instruction);

    T executeInstructions(Iterable<Instruction> instructions);


}
