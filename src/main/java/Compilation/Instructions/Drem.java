package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Drem implements Instruction{

    public void accept(InstructionsVisitor v) {
        v.visit(this);
    }
}
