package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Sub implements Instruction {
    public void accept(InstructionsVisitor v) {
        v.visit(this);
    }
}
