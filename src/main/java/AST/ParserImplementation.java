package AST;

import Lexer.Lexer;
import Lexer.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;


public class ParserImplementation implements Parser {

    private static final Logger logger = LoggerFactory.getLogger(ParserImplementation.class);

    private final Lexer lexer;

    public ParserImplementation(final Lexer lexer) {
        this.lexer = lexer;
    }

    public AbstractSyntaxTree parse(final String expression) {
        logger.warn("Parsing:\n {} \n", expression);
        final List<Token> tokens = lexer.tokenize(expression);
        final AbstractSyntaxTree simpleSyntaxTree = new ASTImplementation(tokens);
        simpleSyntaxTree.build();
        return simpleSyntaxTree;
    }


}
