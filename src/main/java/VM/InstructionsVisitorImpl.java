package VM;

import Compilation.Instructions.*;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Stack;



public class InstructionsVisitorImpl {
    private Stack<Object> stack = new Stack<>();
    Map<String,Integer> vars = Maps.newHashMap();
    int pc;


    public void visit(Add instruction ) {
        int v1 = Integer.parseInt(stack.get(stack.size() - 2).toString());
        int v2 = Integer.parseInt(stack.get(stack.size() - 1).toString());
        stack.add(stack.size() - 2, v1 + v2);
        stack.remove(stack.size() - 1);
        stack.pop();
        pc += 1;
    }

    public void visit(Drem instruction) {

    }

    public void visit(Fetch instruction) {

    }

    public void visit(Func instruction) {

    }

    public void visit(Gt instruction) {

    }

    public void visit(Halt instruction) {

    }

    public void visit(Jmp instruction) {

    }

    public void visit(Jz instruction) {

    }

    public void visit(Lt instruction) {

    }

    public void visit(Ne instruction) {

    }

    public void visit(Pop instruction) {

    }

    public void visit(Push instruction) {

    }

    public void visit(Store instruction) {

    }

    public void visit(Sub instruction) {

    }
}
