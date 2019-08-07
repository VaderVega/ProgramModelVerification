package AST;

import com.google.common.base.Objects;

public class Node {

    private NodeType nodeType;
    private String value = "";
    private Node op1 = null;
    private Node op2 = null;
    private Node op3 = null;

    public String getValue() {

        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getOp1() {
        return op1;
    }

    public void setOp1(Node op1) {
        this.op1 = op1;
    }

    public Node getOp2() {
        return op2;
    }

    public void setOp2(Node op2) {
        this.op2 = op2;
    }

    public Node getOp3() {
        return op3;
    }

    public void setOp3(Node op3) {
        this.op3 = op3;
    }

    public NodeType getNodeType() {

        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return Objects.equal(nodeType, node.nodeType) &&
                Objects.equal(value, node.value) &&
                Objects.equal(op1, node.op1) &&
                Objects.equal(op2, node.op2) &&
                Objects.equal(op3, node.op3);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nodeType, value, op1, op2, op3);
    }


    public enum NodeType {
        VAR, CONST, ADD, SUB, MOD, LT, GT, NE,  SET, IF, IF_ELSE, WHILE, EMPTY, SEQ, EXPR, ROOT, FUNC, DECL, VARTYPE, RETURN, RETURNVALUE, PARAMS
    }
}
