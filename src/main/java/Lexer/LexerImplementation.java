package Lexer;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import Lexer.Token.TokenType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;
import static Lexer.Token.TokenType.*;


public class LexerImplementation implements Lexer {

    private static final Logger logger = LoggerFactory.getLogger(LexerImplementation.class);

    public List<Token> tokenize(final String expression) {
        logger.warn("Performing lexical analysis");
        final List<TokenType> tokenTypes = Lists.newArrayList(values());
        final String regex = tokenTypes
                .stream()
                .reduce("",
                        (s, tokenType) -> s + String.format("|(?<%s>%s)", tokenType.name(), tokenType.getPattern()),
                        (s1, s2) -> s1 + s2);
        final Pattern tokenPatterns = Pattern.compile(regex.substring(1)); // remove leading '|' symbol
        final Matcher matcher = tokenPatterns.matcher(expression);
        final List<Token> tokens = Lists.newArrayList();
        while (matcher.find()) {
            tokenTypes
                    .stream()
                    .filter(tokenType -> tokenType != WHITESPACE)
                    .forEachOrdered(tokenType -> {
                        final Optional<String> matched = Optional.ofNullable(matcher.group(tokenType.name()));
                        matched.ifPresent(s -> {
                            final Token token = new Token(tokenType, s);
                            final Optional<Token> lastToken = Optional.ofNullable(Iterables.getLast(tokens, null));
                            lastToken.ifPresent(t -> {
                                if (!t.equals(token)) {
                                    Preconditions.checkState(tokenType != ERROR, "unexpected token: {}", token);
                                }
                            });
                            tokens.add(token);
                        });
                    });
        }
        logger.warn("Recognized {} tokens: \n{}", tokens.size(), tokens.stream()
                .map(Token::toString)
                .collect(joining("\n")));
        return tokens;
    }
}
