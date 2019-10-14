package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Func implements Instruction {
    public void accept(InstructionsVisitor v) {
        v.visit(this);
    }
}
