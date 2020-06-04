package ControlFlowGraphBuilder;

import GeneratedFiles.MyLangBaseListener;
import GeneratedFiles.MyLangParser;
import IOFeatures.InputFeatures;
import Lexer.Lexer;
import Lexer.Token;
import com.google.common.collect.Queues;
import org.antlr.v4.runtime.Parser;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.io.*;

import java.io.*;
import java.util.*;

import static Compilation.CodeGenerator.Instruction.*;
import static ControlFlowGraphBuilder.CodeBlock.BlockType.*;

public class CFGListener extends MyLangBaseListener {

    private static int level;


    public CFGListener(Parser parser, final Lexer lexer) {
        level = 0;
        this.ruleNames = Arrays.asList(parser.getRuleNames());
        this.lexer = lexer;
    }

    private List<String> ruleNames;

    public CFGListener(List<String> ruleNames) {
        this.ruleNames = ruleNames;
    }


    private CodeBlock currentVertex = null;
    private CodeBlock previousVertex = null;

    private Deque<CodeBlock> ifVertex = new ArrayDeque<>();
    private CodeBlock ifElseVertex = null;
    private boolean endIfBlock = false;
    private boolean endElseBlock = false;

    private Deque<CodeBlock> whileVertex = new ArrayDeque<>();
    private CodeBlock whileCondition = null;
    private boolean endWhileBlock = false;
    private boolean whileConnetcion = false;

    private String place;
    private String literal;



    private Deque<String> instructions = new ArrayDeque<>();
    private Deque<String> variables = new ArrayDeque<>();
    private List<Token> tokensList = new ArrayList<>();
    private Deque<Token> tokens;
    private Lexer lexer;
    private final Map<String, String> vars = new HashMap<>();
    private final List<Object> program = new ArrayList<>();
    private int pc = 0;
    private int adr1, adr2;

    public void printCommands() {
        for(Object x : program) {
            System.out.println(x);
        }
    }


    Graph<CodeBlock, DefaultEdge> controlFlowGraph = new DirectedMultigraph<CodeBlock, DefaultEdge>(DefaultEdge.class);

    private void expression() {
        final Token token = tokens.peek();
        if (token.getTokenType() != Token.TokenType.IDENTIFIER) {
            comparison();
            return;
        }
        comparison();

    }

    private void comparison() {

    }

    private void arithmeticExpression() {

    }

    private void term() {
        while (!tokens.isEmpty()) {
            Token token = tokens.peek();
            Token.TokenType tokenType = token.getTokenType();
            switch (tokenType) {
                case IDENTIFIER:

                    break;
                case NUMBER:
                    gen(IPUSH);
                    gen(token.getToken());
                    break;
                case OPERATOR:
                    if (token.getToken().equals(">")) {

                    }
                    break;

            }
        }
    }

    private void setVertexesAndEdges(String current) {

        CodeBlock currentBlock = new CodeBlock(current);
        if (!ifVertex.isEmpty() && current.equals("else")) {
            ifElseVertex = currentVertex;
            controlFlowGraph.addVertex(currentBlock);
            controlFlowGraph.addEdge(ifVertex.pop(), currentBlock);
            currentVertex = currentBlock;
            endIfBlock = false;
            return;
        }
        if (endElseBlock) {
            currentVertex = currentBlock;
            controlFlowGraph.addVertex(currentVertex);

            endElseBlock = false;
            return;
        }

        if (!whileVertex.isEmpty() && endWhileBlock) {
            whileCondition = whileVertex.pop();
            controlFlowGraph.addEdge(whileCondition, currentVertex);
            currentVertex = currentBlock;
            whileConnetcion = true;
            endWhileBlock = false;
            return;
        }
        if (whileConnetcion) {
            previousVertex = currentVertex;
            currentVertex = currentBlock;
            controlFlowGraph.addVertex(currentVertex);
            controlFlowGraph.addEdge(whileCondition, currentVertex);
            whileConnetcion = false;
            return;
        }

        if (previousVertex == null) {
            currentVertex = currentBlock;
            previousVertex = currentVertex;
            controlFlowGraph.addVertex(currentVertex);
        } else {
            previousVertex = currentVertex;
            currentVertex = currentBlock;
            controlFlowGraph.addVertex(currentVertex);
            controlFlowGraph.addEdge(previousVertex, currentVertex);
        }
    }

    private void setIfVertex() {
        currentVertex.setType(IF);
        ifVertex.push(currentVertex);
    }

    private void setWhileVertex() {
        currentVertex.setType(WHILE);
        whileVertex.push(currentVertex);
    }

    @Override public void enterBlock(MyLangParser.BlockContext ctx) {
        System.out.println("enter block");
    }

    @Override public void exitBlock(MyLangParser.BlockContext ctx) {
        System.out.println("exit block " + currentVertex);
        whileCondition = whileVertex.peek();
        if (controlFlowGraph.containsEdge(currentVertex, whileCondition)) {
            return;
        }
        if (!whileVertex.isEmpty()) {
            controlFlowGraph.addEdge(currentVertex, whileCondition);
        }
    }


    @Override
    public void enterStatementExpr(MyLangParser.StatementExprContext ctx) {
        System.out.println("enter statement;");
        setVertexesAndEdges(ctx.getText());

    }



    @Override
    public void exitStatementExpr(MyLangParser.StatementExprContext ctx) {

        tokensList = lexer.tokenize(currentVertex.getCode());
        tokens = Queues.newArrayDeque(tokensList);
        String leftValue = "";
        String rightValue = "";
        String operator = "";
        String previous = "";
        String current = "";

        while (!tokens.isEmpty()) {
            Token token = tokens.peek();
            Token.TokenType tokenType = token.getTokenType();
            previous = current;
            current = token.getToken();
            if (tokenType.equals(Token.TokenType.OPERATOR)) {
                if (token.getToken().equals(":=")) {
                    variables.addLast(previous);
                } else if (token.getToken().equals("+")) {
                    leftValue = previous;
                    tokens.poll();
                    rightValue = tokens.peek().getToken();

                }
                operator = token.getToken();
            }
            tokens.poll();
        }

            gen(IPUSH);                                                             // CONST
            gen(literal);

            gen(ISTORE);                                                            // SET
            gen(variables.removeFirst());


        if (operator == "-") {
            gen(IFETCH);                                                            // VAR
            gen(variables.removeFirst());

            gen(IFETCH);                                                            // VAR
            gen(variables.removeFirst());

            gen(ISUB);                                                              // SUB
        }

        if (operator == "+") {
            gen(IFETCH);                                                            // VAR
            gen(variables.removeFirst());

            gen(IFETCH);                                                            // VAR
            gen(variables.removeFirst());

            gen(IADD);                                                              // ADD
        }


        System.out.println(operator);

        gen(IPOP);                                                              // EXPR

        String code = currentVertex.getCode();

        System.out.println("exit statement: " + code);

    }
    @Override
    public void enterLiteral(MyLangParser.LiteralContext ctx) {
        System.out.println("enter literal");
    }


    @Override
    public void exitLiteral(MyLangParser.LiteralContext ctx) {
        literal = ctx.getText();

        System.out.println("literal: " + ctx.getText());
    }

    @Override
    public void enterPlace(MyLangParser.PlaceContext ctx) {
        variables.addLast(ctx.getText());
        System.out.println("place: " + ctx.getText());
    }

    @Override
    public void exitPlace(MyLangParser.PlaceContext ctx) {
        System.out.println("exit place");
    }


    @Override
    public void enterIfCondition(MyLangParser.IfConditionContext ctx) {
        String result = "if " + ctx.getText();
        setVertexesAndEdges(result);
        setIfVertex();
    }

    @Override
    public void enterThenStatements(MyLangParser.ThenStatementsContext ctx) {

    }

    @Override
    public void exitThenStatements(MyLangParser.ThenStatementsContext ctx) {

    }

    @Override
    public void enterStatementIf(MyLangParser.StatementIfContext ctx) {

    }

    @Override
    public void exitStatementIf(MyLangParser.StatementIfContext ctx) {
        endIfBlock = true;
    }

    @Override
    public void enterWhileCondition(MyLangParser.WhileConditionContext ctx) {
        String result = "while " + ctx.getText();
        System.out.println("enter while condition");


        setVertexesAndEdges(result);
        adr1 = pc;
        setWhileVertex();
    }

    @Override public void exitWhileCondition(MyLangParser.WhileConditionContext ctx) {
        System.out.println("exit while condition");



        String operator = currentVertex.getCode().replaceAll("[a-zA-Z_]([a-zA-Z_0-9])*|;|[0-9]+", "");
        if (operator.length() > 2) {
            operator = operator.replace(":=", "");
            System.out.println(":=");
        }

        if (operator.equals("!=")) {
            System.out.println(operator);

            gen(INE);
        }
    }

    @Override
    public void enterWhileStatements(MyLangParser.WhileStatementsContext ctx) {
        System.out.println("enter while statements");
    }

    @Override
    public void exitWhileStatements(MyLangParser.WhileStatementsContext ctx) {
        endWhileBlock = true;
        whileCondition = whileVertex.pop();
        controlFlowGraph.addEdge(whileCondition, currentVertex);
        whileConnetcion = true;
        endWhileBlock = false;
    }


    @Override
    public void enterElseStatements(MyLangParser.ElseStatementsContext ctx) {
        String result = "else";
        setVertexesAndEdges(result);
    }

    @Override
    public void exitElseStatements(MyLangParser.ElseStatementsContext ctx) {
        endElseBlock = true;
    }

    public void dotExporter  () throws org.jgrapht.io.ExportException {
        IntegerComponentNameProvider<CodeBlock> integer = new IntegerComponentNameProvider<>();
        ComponentNameProvider<String> vertexIdProvider = codeBlock -> codeBlock;
        ComponentNameProvider<CodeBlock> vertexLabelProvider = CodeBlock::getCode;

        InputFeatures ioFeatures = new InputFeatures();


        GraphExporter<CodeBlock, DefaultEdge> exporter = new DOTExporter<>(integer,
            vertexLabelProvider, null);
        Writer writer = new StringWriter();
        exporter.exportGraph(controlFlowGraph, writer);
        ioFeatures.writeFile(writer.toString(), "cfg.dot");
    }


    public void gen(final Object command) {
        pc++;
        program.add(command.toString());
    }


}
