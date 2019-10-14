package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Fetch implements Instruction {

    private String varName;

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public void accept(InstructionsVisitor v) {
        v.visit(this);
    }
}
