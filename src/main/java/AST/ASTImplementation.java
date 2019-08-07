package AST;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import Lexer.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Queue;

import static AST.Node.NodeType.*;


/**
 * Created by Sergei
 */

public class ASTImplementation implements AbstractSyntaxTree {

    private static final Logger logger = LoggerFactory.getLogger(ASTImplementation.class);

    private final Node root = new Node();
    private int tabCount = 0;
    private final Queue<Token> tokens;

    public ASTImplementation(final List<Token> tokens) {
        this.tokens = Queues.newArrayDeque(tokens);
    }

    public void build() {
        logger.warn("Building AST for {} tokens", tokens.size());
        this.root.setNodeType(ROOT);
        this.root.setOp1(statement());
    }

    public void display(Node node) {
        String tab ="\t";
        if (node == null)
            return;
        for (int i = 0; i < tabCount; i++) {
            tab += "\t";
        }
        System.out.print(tab);
        if (node.getValue().equals("")) {
            System.out.print(node.getNodeType() + "\n");
        } else {
            System.out.print(node.getNodeType() + ": " + node.getValue() + "\n");
        }
        tabCount++;
        display(node.getOp1());
        display(node.getOp2());
        display(node.getOp3());
        tabCount--;
    }

    public void display() {
        logger.warn("Displaying AST:");
        String tab = "\t";
        Node node = this.root;
        if (node == null)
            return;
        if (node.getValue().equals("")) {
            System.out.print(node.getNodeType() + "\n");
        } else {
            System.out.print(node.getNodeType() + ": " + node.getValue() + "\n");
        }
        display(node.getOp1());
        display(node.getOp2());
        display(node.getOp3());
    }

    public void CSTBuild() {
        logger.warn("Building CST:");
        System.out.println("source");
        System.out.println("\tsourceItem");

    }

    private Node statement() {
        final Token next = tokens.peek();
        Node n = new Node();
        switch (next.getToken()) {
            case "if":
                n.setNodeType(IF);
                tokens.poll();
                n.setOp1(condition());
                if (tokens.peek().getToken().equals("then"))
                    tokens.remove();
                n.setOp2(statement());
                if (tokens.peek().getToken().equals("else")) {
                    n.setNodeType(IF_ELSE);
                    tokens.remove();
                    n.setOp3(statement());
                }

                break;
            case "while":
                n.setNodeType(WHILE);
                tokens.poll();
                n.setOp1(condition());
                if (tokens.peek().getToken().equals("do"))
                    tokens.remove();
                n.setOp2(statement());
                break;
            case ";":
                n.setNodeType(EMPTY);
                tokens.poll();
                break;
            case ",":
                n.setNodeType(EMPTY);
                tokens.poll();
                break;
            case "{":
                n.setNodeType(EMPTY);
                tokens.poll();
                while (!tokens.peek().getToken().equals("}")) {
                    Node n2 = new Node();
                    n2.setNodeType(SEQ);
                    n2.setOp1(n);
                    n2.setOp2(statement());
                    n = n2;
                }
                tokens.poll();
                break;
            case "begin":
                n.setNodeType(EMPTY);
                tokens.poll();
                while (!tokens.peek().getToken().equals("end")) {
                    Node n2 = new Node();
                    n2.setNodeType(SEQ);
                    n2.setOp1(n);
                    n2.setOp2(statement());
                    n = n2;

                }
                tokens.poll();
                tokens.remove();
                break;
            case "method":
                n.setNodeType(FUNC);
                tokens.poll();
                n.setValue(tokens.poll().getToken());
                n.setOp1(params());
                n.setOp2(returnValueType());
                n.setOp3(statement());
                break;
            case "var":
                n.setNodeType(VAR);
                tokens.poll();
                n.setOp1(statement());
                break;
            case "return":
                n.setNodeType(RETURNVALUE);
                tokens.poll();
                n.setOp1(term());
                break;
            default:
                n.setNodeType(EXPR);
                n.setOp1(expression());
                if (tokens.peek().getToken().equals(",")) {
                    statement();
                } else if (tokens.peek().getToken().equals(")")) {
                    return n;
                } else {
                    Preconditions.checkState(tokens.peek().getToken().equals(";"), "';' expected");
                    tokens.remove();
                }
                break;
        }
        return n;
    }


    private Node params() {
        Token token = tokens.poll();
        Preconditions.checkState(token.getToken().equals("("), "'(' expected");
        Node node = new Node();
        node.setNodeType(PARAMS);
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        for (int i = 0; i < 3; i++) {
            if (!tokens.peek().getToken().equals(")") & i ==0) {
                node1 = statement();
                node.setOp1(node1);
            } else if (!tokens.peek().getToken().equals(")") & i == 1) {
                node2 = statement();
                node.setOp2(node2);
            } else if (!tokens.peek().getToken().equals(")") & i == 2) {
                node3 = statement();
                node.setOp3(node3);
            }
        }
        tokens.poll();
        return node;
    }

    private Node returnValueType() {
        Node node = new Node();
        if(tokens.peek().getToken().equals(":")) {
            tokens.poll();
            Node node2 = new Node();
            node2.setNodeType(RETURN);
            //node2.setOp1(node);
            node2.setOp1(expression());
            node = node2;
        }
        return node;
    }

    private Node condition() {
        final Token token = tokens.poll();
        Preconditions.checkState(token.getToken().equals("("), "'(' expected");
        Node node = expression();
        Preconditions.checkState(tokens.poll().getToken().equals(")"), "')' expected");
        return node;
    }

    private Node expression() {
        final Token token = tokens.peek();
        if (token.getTokenType() != Token.TokenType.IDENTIFIER) {
            return test();
        }
        Node node = test();
        if (node.getNodeType() == VAR && tokens.peek().getToken().equals(":=")) {
            tokens.poll();
            Node node2 = new Node();
            node2.setNodeType(SET);
            node2.setOp1(node);
            node2.setOp2(expression());
            node = node2;
        } else if (node.getNodeType() == VAR && tokens.peek().getToken().equals(":")) {
            tokens.poll();
            Node node2 = new Node();
            node2.setNodeType(DECL);
            node2.setOp1(node);
            node2.setOp2(expression());
            node = node2;
        }
        return node;
    }

    private Node test() {
        Node node = arithmeticExpression();
        final String peek = tokens.peek().getToken();
        if (peek.equals("<")) {
            tokens.remove();
            Node node2 = new Node();
            node2.setNodeType(LT);
            node2.setOp1(node);
            node2.setOp2(arithmeticExpression());
            node = node2;
        } else if (peek.equals(">")) {
            tokens.remove();
            Node node2 = new Node();
            node2.setNodeType(GT);
            node2.setOp1(node);
            node2.setOp2(arithmeticExpression());
            node = node2;
        } else if (peek.equals("!")) {
            tokens.remove();
            if (tokens.peek().getToken().equals("=")) {
                tokens.remove();
                Node node2 = new Node();
                node2.setNodeType(NE);
                node2.setOp1(node);
                node2.setOp2(arithmeticExpression());
                node = node2;
            }
        }
        return node;
    }

    @Override
    public Node getRoot() {
        return root;
    }

    private Node arithmeticExpression() {
        Node node = term();
        while (tokens.peek().getToken().equals("+") || tokens.peek().getToken().equals("-") || tokens.peek().getToken().equals("%")) {
            final Node.NodeType nodeType;
            if (tokens.peek().getToken().equals("+")) {
                nodeType = ADD;
            } else if (tokens.peek().getToken().equals("-")) {
                nodeType = SUB;
            } else {
                nodeType = MOD;
            }
            tokens.remove();
            Node node2 = new Node();
            node2.setNodeType(nodeType);
            node2.setOp1(node);
            node2.setOp2(term());
            node = node2;
        }
        return node;
    }

    private Node term() {
        final Token token = tokens.peek();
        final Token.TokenType tokenType = token.getTokenType();
        Node node = new Node();
        switch (tokenType) {
            case IDENTIFIER:
                node.setNodeType(VAR);
                node.setValue(token.getToken());
                tokens.poll();
                return node;
            case NUMBER:
                node.setNodeType(CONST);
                node.setValue(token.getToken());
                tokens.poll();
                return node;
            case VARTYPE:
                node.setNodeType(VARTYPE);
                node.setValue(token.getToken());
                tokens.poll();
                return node;
            default:
                return expression();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ASTImplementation that = (ASTImplementation) o;
        return Objects.equal(root, that.root) &&
                Objects.equal(tokens, that.tokens);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(root, tokens);
    }
}
