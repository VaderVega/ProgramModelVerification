package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Jz implements Instruction{
    public void accept(InstructionsVisitor v){
        v.visit(this);
    }
}
