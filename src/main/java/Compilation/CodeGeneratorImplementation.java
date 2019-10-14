package Compilation;

import AST.AbstractSyntaxTree;
import AST.Node;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static AST.Node.NodeType.*;
import static AST.Node.NodeType.FUNC;
import static Compilation.CodeGenerator.Instruction.*;
import static java.util.stream.Collectors.joining;

public class CodeGeneratorImplementation implements CodeGenerator {
    private static final Logger logger = LoggerFactory.getLogger(CodeGeneratorImplementation.class);

    private final Map<String, String> vars = Maps.newHashMap();
    private final List<Object> program = Lists.newArrayList();
    private int pc = 0;

    private boolean isDll = false;

    @Override
    public List<String> compile(final AbstractSyntaxTree tree) {
        logger.warn("Compiling AST");
        init();
        compile(tree.getRoot());
        final List<String> instructions = program.stream().map(Object::toString).collect(Collectors.toList());
        for (int i = 2; i < 4; i++)
            instructions.remove(instructions.size() - i);
        instructions.remove(instructions.size() - 2);
        logger.warn("Compilation finished, compiled {} instructions:\n{}", instructions.size(),
                instructions.stream()
                        .collect(joining("\n")));

        return instructions;
    }

    private void init() {
        pc = 0;
        vars.clear();
        program.clear();
    }

    private void compile(final Node node) {
        switch (node.getNodeType()) {
            case VAR:
                gen(IFETCH);
                gen(node.getValue());
                break;
            case CONST:
                gen(IPUSH);
                gen(node.getValue());
                break;
            case ADD:
                compile(node.getOp1());
                compile(node.getOp2());
                gen(IADD);
                break;
            case SUB:
                compile(node.getOp1());
                compile(node.getOp2());
                gen(ISUB);
                break;
            case MOD:
                compile(node.getOp1());
                compile(node.getOp2());
                gen(DREM);
                break;
            case LT:
                compile(node.getOp1());
                compile(node.getOp2());
                gen(ILT);
                break;
            case GT:
                compile(node.getOp1());
                compile(node.getOp2());
                gen(IGT);
                break;
            case NE:
                compile(node.getOp1());
                compile(node.getOp2());
                gen(INE);
                break;
            case SET:
                compile(node.getOp2());
                gen(ISTORE);
                gen(node.getOp1().getValue());
                break;
            case IF:
                compile(node.getOp1());
                gen(JZ);
                int adr = pc;
                gen(0);
                compile(node.getOp2());
                program.set(adr, pc);
                break;
            case IF_ELSE:
                compile(node.getOp1());
                gen(JZ);
                int adr1 = pc;
                gen(0);
                compile(node.getOp2());
                gen(JMP);
                int adr2 = pc;
                gen(0);
                program.set(adr1, pc);
                compile(node.getOp3());
                program.set(adr2, pc);
                break;
            case WHILE:
                adr1 = pc;
                compile(node.getOp1());
                gen(JZ);
                adr2 = pc;
                gen(0);
                compile(node.getOp2());
                gen(JMP);
                gen(adr1);
                program.set(adr2, pc);
                break;
            case SEQ:
                compile(node.getOp1());
                compile(node.getOp2());
                break;
            case EXPR:
                compile(node.getOp1());
                if (node.getOp2() != null && node.getOp2().getNodeType() != null)
                    compile(node.getOp2());
                gen(IPOP);
                break;
            case ROOT:
                compile(node.getOp1());
                gen(HALT);
                break;
            case FUNC:
                gen(IFUNC);
                //if (node.get)
                gen(node.getValue());
                if (node.getOp2() != null)
                    compile(node.getOp2());
                compile(node.getOp1());
                //compile(node.getOp2());
                if (node.getOp3() != null)
                    compile(node.getOp3());
                break;
            case CLASS:
                gen(ICLASS);
                compile(node.getOp1());
            case DLL:
                gen(IDLL);
                gen(node.getValue());
                //co
                break;
            case PARAMS:
                if (!(node.getValue().equals("")))
                gen(node.getValue());
                break;
            case FUNCCALL:
                gen(IFUNCCALL);
                gen(node.getValue());
                break;
            case FUNCPARAMS:
                if (node.getOp1() != null)
                    compile(node.getOp1());
                if (node.getOp2() != null)
                    compile(node.getOp2());
                if (node.getOp3() != null)
                    compile(node.getOp3());
                break;
            case FUNCPARAM:
                gen(IFUNCPARAM);
                gen(node.getValue());
                break;
            case DECL:
                break;
            case VARTYPE:
                break;
            case RETURN:
                break;
        }
    }

    private void gen(final Object command) {
        pc++;
        program.add(command.toString());
    }
}
