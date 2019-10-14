package Compilation.Instructions;

import VM.InstructionsVisitor;

public interface Instruction {
    void accept(InstructionsVisitor visitor);
}
