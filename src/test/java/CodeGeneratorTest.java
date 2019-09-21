import AST.AbstractSyntaxTree;
import AST.Parser;
import AST.ParserImplementation;
import Compilation.CodeGenerator;
import Compilation.CodeGeneratorImplementation;
import Lexer.LexerImplementation;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.*;
import java.net.URL;
import java.util.List;

public class CodeGeneratorTest {
    public static void main(String[] args) {
        Parser parser = new ParserImplementation(new LexerImplementation());
        try {
            URL url = Resources.getResource("test_code.txt");
            String sourceCode = Resources.toString(url, Charsets.UTF_8);
            final AbstractSyntaxTree tree = parser.parse(sourceCode);
            CodeGenerator codeGenerator = new CodeGeneratorImplementation();
            List<String> commands = codeGenerator.compile(tree);
            StringBuilder builder = new StringBuilder();

            for(String str : commands) {
                //System.out.println(str);
                builder.append(str);
                builder.append("\n");
            }

            String pathToFile = "src/test/resources/GeneratedCode.txt";
            String path = "src/test/resources/BinaryCode.bc";
            try(FileWriter writer = new FileWriter(pathToFile))
            {
                System.out.println("Writing code to the file...");
                writer.write(builder.toString());
                writer.flush();
                System.out.println("Writing code complete!");
            }
            catch (IOException ex) {
                System.out.println("Writing code failed!");
            }

            try(FileOutputStream fileOutputStream = new FileOutputStream(path);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {
                outputStream.writeUTF(builder.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try(FileInputStream fileInputStream = new FileInputStream(path);
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {
                String code = inputStream.readUTF();
                System.out.println("\nReading generated code from file:\n");
                System.out.println(code);
            } catch (IOException ex) {
                System.out.println(ex.getStackTrace());
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }




    }


}
