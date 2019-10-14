package VM;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import static Compilation.CodeGenerator.Instruction.*;


public class VirtualMachineImplementation implements VirtualMachine {

    private static final Logger logger = LoggerFactory.getLogger(VirtualMachineImplementation.class);


    private final Stack<Object> stack = new Stack<>();
    private Map<String, Integer> vars = Maps.newHashMap();
    private Map<String, String> varTypes = Maps.newHashMap();
    private Map<String, List<String>> functionsCalls = Maps.newHashMap();


    private int pc = 0;
    private String arg = "";
    private String dllname;
    private String dllFuncName;
    private String dllParams;
    private String funcName;




    @Override
    public void run(final List<String> program) {
        logger.warn("Running {} instructions", program.size());
        init();
        while (true) {
            final String op = program.get(pc);
            if (pc < program.size() - 1) {
                arg = program.get(pc + 1);
            }
            if (op.equals(IFETCH.toString())) {
                stack.push(vars.get(arg));
                pc += 2;
            } else if (op.equals(ISTORE.toString())) {
                vars.put(arg, Integer.parseInt(stack.pop().toString()));
                pc += 2;
            } else if (op.equals(IPUSH.toString())) {
                stack.push(arg);
                pc += 2;
            } else if (op.equals(IPOP.toString())) {
                stack.push(arg);
                stack.pop();
                pc += 1;
            } else if (op.equals(IADD.toString())) {
                int v1 = Integer.parseInt(stack.get(stack.size() - 2).toString());
                int v2 = Integer.parseInt(stack.get(stack.size() - 1).toString());
                stack.add(stack.size() - 2, v1 + v2);
                stack.remove(stack.size() - 1);
                stack.pop();
                pc += 1;
            } else if (op.equals(ISUB.toString())) {
                int v1 = Integer.parseInt(stack.get(stack.size() - 2).toString());
                int v2 = Integer.parseInt(stack.get(stack.size() - 1).toString());
                stack.add(stack.size() - 2, v1 - v2);
                stack.remove(stack.size() - 1);
                stack.pop();
                pc += 1;
            } else if (op.equals(DREM.toString())) {
                int v1 = Integer.parseInt(stack.get(stack.size() - 2).toString());
                int v2 = Integer.parseInt(stack.get(stack.size() - 1).toString());
                stack.add(stack.size() - 2, v1 % v2);
                stack.remove(stack.size() - 1);
                stack.pop();
                pc += 1;
            } else if (op.equals(ILT.toString())) {
                int v1 = Integer.parseInt(stack.get(stack.size() - 2).toString());
                int v2 = Integer.parseInt(stack.get(stack.size() - 1).toString());
                if (v1 < v2) {
                    stack.add(stack.size() - 2, 1);
                } else {
                    stack.add(stack.size() - 2, 0);
                }
                stack.remove(stack.size() - 1);
                stack.pop();
                pc += 1;
            } else if (op.equals(IGT.toString())) {
                int v1 = Integer.parseInt(stack.get(stack.size() - 2).toString());
                int v2 = Integer.parseInt(stack.get(stack.size() - 1).toString());
                if (v1 > v2) {
                    stack.add(stack.size() - 2, 1);
                } else {
                    stack.add(stack.size() - 2, 0);
                }
                stack.remove(stack.size() - 1);
                stack.pop();
                pc += 1;
            } else if (op.equals(INE.toString())) {
                int v1 = Integer.parseInt(stack.get(stack.size() - 2).toString());
                int v2 = Integer.parseInt(stack.get(stack.size() - 1).toString());
                if (v1 != v2) {
                    stack.add(stack.size() - 2, 1);
                } else {
                    stack.add(stack.size() - 2, 0);
                }
                stack.remove(stack.size() - 1);
                stack.pop();
                pc += 1;
            } else if (op.equals(JZ.toString())) {
                if (stack.pop().equals(0)) {
                    pc = Integer.parseInt(arg);
                } else {
                    pc += 2;
                }
            } else if (op.equals(JMP.toString())) {
                pc = Integer.parseInt(arg);
            } else if (op.equals(IFUNC.toString())) {
                pc += 1;
                funcName = program.get(pc++);
                if (program.get(pc).equals(IDLL.toString()))
                    dllFuncName = funcName;

                //op = program.get();
            } else if (op.equals(ICLASS.toString())) {
                pc += 3;
            } else if (op.equals(IDLL.toString())) {

                dllname = program.get(++pc);

                dllParams = program.get(++pc);
                pc++;
            } else if (op.equals(IFUNCCALL.toString())) {
                functionsCalls.put(program.get(++pc), new ArrayList<>());
                funcName = program.get(pc++);

            } else if (op.equals(IFUNCPARAM.toString())) {
               functionsCalls.get(funcName).add(program.get(++pc));
               pc++;
               if (!(program.get(pc).equals(IFUNCPARAM.toString())))
                   runFunc();
            } else if (op.equals(HALT.toString())) {
                break;
            }
        }



        logger.warn("Execution finished. Variables table:\n {}", vars);
    }

    private void runFunc() {
        dllParams = dllParams.replace("\"", "");
        String funcSignature = "void " + dllFuncName + "(" + dllParams + ")";
        InterfaceGenerator ig = new InterfaceGenerator(dllFuncName, funcSignature, dllname, functionsCalls, vars);
        ig.runDll();
    }
    private void init() {
        pc = 0;
        stack.clear();
        vars.clear();
        arg = "";
    }

    public Integer getVar(final String name) {
        return vars.get(name);
    }
}
