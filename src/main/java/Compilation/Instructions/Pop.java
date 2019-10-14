package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Pop implements Instruction {
    public void accept(InstructionsVisitor v) {
        v.visit(this);
    }
}
