package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Halt implements Instruction {
    public void accept(InstructionsVisitor v) {
        v.visit(this);
    }
}
