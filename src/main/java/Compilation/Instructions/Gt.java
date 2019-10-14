package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Gt implements Instruction {
    public void accept(InstructionsVisitor v) {
        v.visit(this);
    }
}
