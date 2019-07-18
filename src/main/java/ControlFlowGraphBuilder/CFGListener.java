package ControlFlowGraphBuilder;

import GeneratedFiles.MyLangBaseListener;
import GeneratedFiles.MyLangParser;
import IOFeatures.InputFeatures;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.io.*;

import java.io.*;
import java.util.*;

public class CFGListener extends MyLangBaseListener {

    private static int level;


    public CFGListener(Parser parser) {
        level = 0;
        this.ruleNames = Arrays.asList(parser.getRuleNames());
    }

    private List<String> ruleNames;

    public CFGListener(List<String> ruleNames) {
        this.ruleNames = ruleNames;
    }



    private String currentVertex = null;
    private String previousVertex = null;

    private Deque<String> ifVertex = new ArrayDeque<>();
    private String ifElseVertex = null;
    private boolean endIfBlock = false;
    private boolean endElseBlock = false;

    private Deque<String> whileVertex = new ArrayDeque<>();
    private String whileCondition = null;
    private boolean endWhileBlock = false;
    private boolean whileConnetcion = false;


    Graph<String, DefaultEdge> controlFlowGraph = new DirectedMultigraph<String, DefaultEdge>(DefaultEdge.class);


    private void setVertexesAndEdges(String current) {

        if (!ifVertex.isEmpty() && current.equals("else")) {
            ifElseVertex = currentVertex;
            controlFlowGraph.addVertex(current);
            controlFlowGraph.addEdge(ifVertex.pop(), current);
            currentVertex = current;
            endIfBlock = false;
            return;
        }
        if (endElseBlock) {
            currentVertex = current;
            controlFlowGraph.addVertex(currentVertex);

            endElseBlock = false;
            return;
        }

        if (!whileVertex.isEmpty() && endWhileBlock) {
            whileCondition = whileVertex.pop();
            controlFlowGraph.addEdge(whileCondition, currentVertex);
            currentVertex = current;
            whileConnetcion = true;
            endWhileBlock = false;
            return;
        }
        if (whileConnetcion) {
            previousVertex = currentVertex;
            currentVertex = current;
            controlFlowGraph.addVertex(currentVertex);
            controlFlowGraph.addEdge(whileCondition, currentVertex);
            whileConnetcion = false;
            return;
        }

        if (previousVertex == null) {
            currentVertex = current;
            previousVertex = currentVertex;
            controlFlowGraph.addVertex(currentVertex);
        } else {
            previousVertex = currentVertex;
            currentVertex = current;
            controlFlowGraph.addVertex(currentVertex);
            controlFlowGraph.addEdge(previousVertex, currentVertex);
        }
    }

    private void setIfVertex(String value) {
        ifVertex.push(value);
    }

    private void setWhileVertex(String value) {
        whileVertex.push(value);
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
        setVertexesAndEdges(ctx.getText());
    }


    @Override
    public void enterIfCondition(MyLangParser.IfConditionContext ctx) {
        String result = "if " + ctx.getText();
        setVertexesAndEdges(result);
        setIfVertex(result);
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
        setVertexesAndEdges(result);
        setWhileVertex(result);
    }

    @Override
    public void enterWhileStatements(MyLangParser.WhileStatementsContext ctx) {

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


    @Override
    public void enterStatementWhile(MyLangParser.StatementWhileContext ctx) {

    }

    @Override
    public void exitStatementWhile(MyLangParser.StatementWhileContext ctx) {

    }

    @Override
    public void enterStatementDo(MyLangParser.StatementDoContext ctx) {

    }

    @Override
    public void exitStatementDo(MyLangParser.StatementDoContext ctx) {

    }

    @Override
    public void enterStatementBreak(MyLangParser.StatementBreakContext ctx) {

    }



    public void exportGraph() throws org.jgrapht.io.ExportException {
        IntegerComponentNameProvider<String> integr = new IntegerComponentNameProvider<>();

        ComponentNameProvider<String> vertexLabelProvider = new ComponentNameProvider<String>() {
            @Override
            public String getName(String codeBlock) {
                return codeBlock.toString();
            }
        };


        ComponentNameProvider<DefaultEdge> edgeIDProvider = new ComponentNameProvider<DefaultEdge>() {
            @Override
            public String getName(DefaultEdge d) {
                return d.toString();
            }
        };
        ComponentNameProvider<String> vertexIDProvider = new ComponentNameProvider<String>() {
            @Override
            public String getName(String s) {
                return s.toString();
            }
        };

        GmlExporter<String, DefaultEdge> exporter = new GmlExporter<String, DefaultEdge>(integr, vertexLabelProvider, edgeIDProvider, null);
        Writer w = new StringWriter();

        exporter.exportGraph(controlFlowGraph, w);
        System.out.println(w.toString());    }

    public void dotExporter  () throws org.jgrapht.io.ExportException {
        IntegerComponentNameProvider<String> integr = new IntegerComponentNameProvider<>();
        ComponentNameProvider<String> vertexIdProvider = new ComponentNameProvider<String>() {
            @Override
            public String getName(String codeBlock) {
                return codeBlock.toString();
            }
        };
        ComponentNameProvider<String> vertexLabelProvider = new ComponentNameProvider<String>() {
            @Override
            public String getName(String codeBlock) {
                return codeBlock.toString();
            }
        };

        InputFeatures ioFeatures = new InputFeatures();


        GraphExporter<String, DefaultEdge> exporter = new DOTExporter<>(integr, vertexLabelProvider, null);
        Writer writer = new StringWriter();
        exporter.exportGraph(controlFlowGraph, writer);
        ioFeatures.writeFile(writer.toString(), "cfg.dot");
        System.out.println(writer.toString());
    }





}
