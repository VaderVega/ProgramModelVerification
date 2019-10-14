package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Lt implements Instruction{
    public void accept(InstructionsVisitor v){
        v.visit(this);
    }
}
