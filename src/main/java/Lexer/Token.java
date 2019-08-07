package Lexer;

import com.google.common.base.Objects;

public class Token {
    private final TokenType tokenType;
    private final String token;

    public Token(final TokenType tokenType, final String token) {
        this.tokenType = tokenType;
        this.token = token;
    }

    @Override
    public String toString() {
        return String.format("{token: '%s', type: %s}", token, tokenType.name());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token1 = (Token) o;
        return Objects.equal(tokenType, token1.tokenType) &&
                Objects.equal(token, token1.token);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tokenType, token);
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getToken() {
        return token;
    }

    public enum TokenType {

        OPERATOR("\\+|-|=|>|<|!|%|:=|:|,"),
        SYMBOL("[\\{|\\}|;|(|)]"),
        VARTYPE("bool|byte|int|uint|long|ulong|char|string"),
        KEYWORD("if|else|while|do|var|then|begin|end|method|return"),
        IDENTIFIER("[a-zA-Z_][a-zA-Z_0-9]*"),                             // идентификатор
        STR("\\\"[^\\\"\\\\]*(?:\\\\.[^\\\"\\\\]*)*\\\""),                // строка, окруженная двойными кавычками
        CHAR("'[^']'"),                                                   // одиночный символ в одинарных кавычках
        HEX("0[xX][0-9A-Fa-f]+"),                                         // шестнадцатеричный литерал
        BITS("0[bB][01]+"),                                               // битовый литерал
        NUMBER("-?[0-9]+"),                                               // десятичный литерал
        BOOL("true'|'false"),                                             // булевский литерал
        WHITESPACE("[\\s]+"),
        ERROR(".+");

        private final String pattern;

        public String getPattern() {
            return pattern;
        }

        TokenType(final String pattern) {
            this.pattern = pattern;
        }
    }
}
