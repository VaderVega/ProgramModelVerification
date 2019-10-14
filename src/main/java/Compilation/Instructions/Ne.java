package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Ne implements Instruction{
    public void accept(InstructionsVisitor v) {
        v.visit(this);
    }
}
