package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Jmp implements Instruction {
    public void accept(InstructionsVisitor v) {
        v.visit(this);
    }
}
