package Compilation.Instructions;

import VM.InstructionsVisitor;

public class Push implements Instruction {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void accept(InstructionsVisitor v) {
        v.visit(this);
    }
}
