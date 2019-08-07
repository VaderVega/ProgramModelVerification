package Lexer;

import java.util.List;

public interface Lexer {
    List<Token> tokenize(final String expression);
}
