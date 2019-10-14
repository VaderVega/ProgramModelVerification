package VM;

import Compilation.Instructions.*;

import java.util.Map;
import java.util.Stack;

public interface InstructionsVisitor {
    void visit(Add instruction);

    void visit(Drem instruction);

    void visit(Fetch instruction);

    void visit(Func instruction);

    void visit(Gt instruction);

    void visit(Halt instruction);

    void visit(Jmp instruction);

    void visit(Jz instruction);

    void visit(Lt instruction);

    void visit(Ne instruction);

    void visit(Pop instruction);

    void visit(Push instruction);

    void visit(Store instruction);

    void visit(Sub instruction);
}
