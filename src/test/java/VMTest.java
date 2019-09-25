import AST.AbstractSyntaxTree;
import AST.Parser;
import AST.ParserImplementation;
import Compilation.CodeGenerator;
import Compilation.CodeGeneratorImplementation;
import Lexer.LexerImplementation;
import VM.VirtualMachineImplementation;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class VMTest {
    public static void main(String[] args) {
        Parser parser = new ParserImplementation(new LexerImplementation());
        try {
            URL url = Resources.getResource("test_code.txt");
            String sourceCode = Resources.toString(url, Charsets.UTF_8);
            final AbstractSyntaxTree tree = parser.parse(sourceCode);
            CodeGenerator codeGenerator = new CodeGeneratorImplementation();
            List<String> commands = codeGenerator.compile(tree);

            VirtualMachineImplementation vm = new VirtualMachineImplementation();
            vm.run(commands);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
