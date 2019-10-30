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



public class ASTImplementation implements AbstractSyntaxTree {

    private static final Logger logger = LoggerFactory.getLogger(ASTImplementation.class);

    private final Node root = new Node();
    private int tabCount = 0;
    private final Queue<Token> tokens;

    private boolean userType;
    private boolean dll = true;


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
                //tokens.remove();
                break;
            case "method":

                n.setNodeType(FUNC);
                tokens.poll();
                n.setValue(tokens.poll().getToken());
                n.setOp1(params());
                n.setOp2(returnValueType());
                if (!dll) {
                    n.setOp3(statement());
                }
                dll = false;

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
            case "from":
                n.setNodeType(DLL);
                tokens.poll();
                n.setValue(tokens.poll().getToken());
                break;
            case "class":
                n.setNodeType(CLASS);
                tokens.poll();
                n.setValue(tokens.poll().getToken());
                n.setOp1(classVars());
                n.setOp2(statement());
                break;
            default:


                n.setNodeType(EXPR);
                                            //funcCall
                n.setOp1(expression());
                Node node = new Node();
                n.setOp2(node);
                if (next.getTokenType().equals(Token.TokenType.IDENTIFIER) && tokens.peek().getToken().equals("(")) {
                    System.out.println("test");
                    tokens.poll();
                    for (int i = 0; i < 3; i++) {
                        if (i == 0 && !(tokens.peek().getToken().equals(")"))) {
                            Node n1 = new Node();
                            n1.setNodeType(FUNCPARAM);
                            n1.setValue(tokens.poll().getToken());
                            tokens.poll();
                            node.setOp1(n1);
                            continue;
                        } else if (i == 1 && !(tokens.peek().getToken().equals(")"))) {
                            Node n2 = new Node();
                            n2.setNodeType(FUNCPARAM);
                            n2.setValue(tokens.poll().getToken());
                            tokens.poll();
                            node.setOp2(n2);
                            continue;
                        } else if (i == 3 && !(tokens.peek().getToken().equals(")"))){
                            Node n3 = new Node();
                            n3.setNodeType(FUNCPARAM);
                            n3.setValue(tokens.poll().getToken());
                            tokens.poll();
                            node.setOp3(n3);
                        }

                        tokens.poll();
                    }
                    node.setNodeType(FUNCPARAMS);

                    return n;
                }
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


    private Node classVars() {
        Node node = new Node();
        node.setNodeType(CLASSVARS);
        Token token = tokens.poll();
        Preconditions.checkState(token.getToken().equals("var"), "\"var\" expected in class declaration");
        Node previousNode = new Node();
        previousNode.setNodeType(SEQ);
        node.setOp1(previousNode);
        while (!tokens.peek().getToken().equals("begin")) {
            Node currentNode = new Node();
            currentNode.setNodeType(SEQ);
            currentNode.setOp1(statement());
            previousNode.setOp2(currentNode);
            previousNode = currentNode;
        }
        return node;
    }

    private Node params() {
        Token token = tokens.poll();
        Preconditions.checkState(token.getToken().equals("("), "'(' expected");
        Node node = new Node();

        if (tokens.peek().getTokenType().equals(Token.TokenType.STR)) {
            node.setNodeType(PARAMS);
            node.setValue(tokens.poll().getToken());
            tokens.poll();
            dll = true;
            return node;
        }

        node.setNodeType(PARAMS);


        Node previousNode = new Node();
        previousNode.setNodeType(SEQ);
        node.setOp1(previousNode);
        while (!tokens.peek().getToken().equals(")")) {
            Node currentNode = new Node();
            currentNode.setNodeType(SEQ);
            currentNode.setOp1(statement());
            previousNode.setOp2(currentNode);
            previousNode = currentNode;
        }

        tokens.poll();
        return node;
    }

    private Node returnValueType() {
        Node node = new Node();
        if (tokens.peek().getToken().equals(":")) {
            tokens.poll();
            Node node2 = new Node();
            node2.setNodeType(RETURN);
            //node2.setOp1(node);
            node2.setOp1(expression());
            node = node2;
        } else if (tokens.peek().getToken().equals("from")) {
            tokens.poll();
            node.setNodeType(DLL);
            node.setValue(tokens.poll().getToken());
        }
        return node;
    }

    private Node condition() {
        //final Token token = tokens.poll();
        //Preconditions.checkState(token.getToken().equals("("), "'(' expected");
        Node node = expression();
        //Preconditions.checkState(tokens.poll().getToken().equals(")"), "')' expected");
        return node;
    }

    private Node expression() {
        final Token token = tokens.peek();
        /*
        if (token.getTokenType() == Token.TokenType.VARTYPE && classFields) {
            Node node = new Node();
            node.setNodeType(DECL);
            node.setValue(token.getToken());
            tokens.poll();
            node.setOp1(term());
            return node;
        }
        */

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
            if (!tokens.peek().getTokenType().equals(Token.TokenType.VARTYPE) || !tokens.peek().getTokenType().equals(Token.TokenType.KEYWORD)) {
                //userType = true;
            }
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
        final Token token = tokens.poll();
        final Token.TokenType tokenType = token.getTokenType();
        Node node = new Node();
        switch (tokenType) {
            case IDENTIFIER:
                if (tokens.peek().getToken().equals("(")) {
                    node.setNodeType(FUNCCALL);
                    node.setValue(token.getToken());
                    //tokens.poll();
                    return  node;
                } else if (userType){
                    node.setNodeType(USERTYPE);
                    node.setValue(token.getToken());
                    userType = false;
                    return node;
                } else if (tokens.peek().getToken().equals(".")) {
                    node.setNodeType(FIELDCALL);
                    node.setValue(token.getToken());
                    tokens.poll();
                    node.setOp1(term());
                    return node;
                }
                node.setNodeType(VAR);
                node.setValue(token.getToken());
                //tokens.poll();
                return node;
                /*
            case KEYWORD:
                node.setNodeType(ARRAY);

                tokens.poll();
                tokens.poll();
                tokens.poll();

                node.setOp1(term());

                return node;*/
            case NUMBER:
                node.setNodeType(CONST);
                node.setValue(token.getToken());
                //tokens.poll();
                return node;
            case VARTYPE:
                node.setNodeType(VARTYPE);
                node.setValue(token.getToken());
                //tokens.poll();
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
