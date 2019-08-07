package ControlFlowGraphBuilder;

public class CodeBlock {
    private String code;
    private BlockType type = null;

    public CodeBlock(String code) {
        this.code = code;
    }

    public CodeBlock(String code, BlockType type) {
        this.code = code;
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setType(BlockType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public BlockType getType() {
        return type;
    }

    public enum BlockType {
        VAR, CONST, ADD, SUB, MOD, LT, GT, NE,  SET, IF, IF_ELSE, WHILE, EMPTY, SEQ, EXPR, ROOT, FUNC, DECL, VARTYPE, RETURN, RETURNVALUE, PARAMS
    }
}
