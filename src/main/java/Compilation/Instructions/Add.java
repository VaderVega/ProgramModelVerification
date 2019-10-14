package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Add implements Instruction{

    public void accept(InstructionsVisitor v) {
        v.visit(this);
    }
}
