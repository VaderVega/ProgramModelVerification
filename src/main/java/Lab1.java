import ControlFlowGraphBuilder.CFGListener;
import IOFeatures.InputFeatures;
import Lexer.LexerImplementation;
import TreeBuilder.CSTListener;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;


import GeneratedFiles.MyLangLexer;
import GeneratedFiles.MyLangParser;


public class Lab1 {
    public static void main(String [] args) throws IOException {
        InputFeatures ioFeatures = new InputFeatures();

        GeneratedFiles.MyLangLexer lexer = new MyLangLexer(CharStreams.fromStream(ioFeatures.getFile("code.txt")));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MyLangParser parser = new MyLangParser(tokens);
        ParseTree tree = parser.source();

        CSTListener listener = new CSTListener(parser);

        CFGListener cfgListener = new CFGListener(parser, new LexerImplementation());
        ParseTreeWalker.DEFAULT.walk(listener, tree);
        ParseTreeWalker.DEFAULT.walk(cfgListener, tree);
        ioFeatures.writeFile(listener.toString(), "out.txt");
        try{
            cfgListener.dotExporter();
        } catch (org.jgrapht.io.ExportException ex) {
            ex.getStackTrace();
        }
        cfgListener.printCommands();


    }
}