import AST.AbstractSyntaxTree;
import AST.Parser;
import AST.ParserImplementation;
import Lexer.LexerImplementation;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

public class CustomParserTest {
    public static void main(String [] args) {
        final Parser parser = new ParserImplementation(new LexerImplementation());
        try {
            URL url = Resources.getResource("test_code.txt");
            String sourceCode = Resources.toString(url, Charsets.UTF_8);
            final AbstractSyntaxTree tree = parser.parse(sourceCode);
            tree.display();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }
}
