package VM;




import javax.tools.*;
import java.io.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InterfaceGenerator {

    private String fileName = "./target/classes/VM/GeneratedClass.java";
    private String className = "./target/classes/VM/GeneratedClass.class";

    private String funcSignature;
    private String funcParams;
    private String dllName;
    private String funcName;

    private Map<String, List<String>> functionsCalls;
    private Map<String, Integer> vars;

    public InterfaceGenerator(String funcName, String funcSignature, String dllName, Map<String, List<String>> functionsCalls, Map<String, Integer> vars) {
        this.funcSignature = funcSignature;
        this.funcName = funcName;
        this.dllName = dllName;
        this.functionsCalls = functionsCalls;
        this.vars = vars;
    }

    public void runDll() {
        try {
            buildCode();
            compileCode();
            runCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildCode() throws IOException {


        File[] f = new File[] { new File(fileName), new File(className) };

        for (File file : f)
            file.delete();

        StringBuilder sb = new StringBuilder();
        sb.append(funcName);
        sb.append("(");
        functionsCalls.get(funcName).forEach((str) -> sb.append(str + ","));
        sb.append(")");
        sb.replace(sb.length() - 2, sb.length() - 1, "");
        String funcCall = sb.toString();

        sb.delete(0, sb.length());

        for (int i = 0; i < functionsCalls.get(funcName).size(); i++) {
            if ( vars.containsKey(functionsCalls.get(funcName).get(i)) ) {
                sb.append("int ");
                sb.append(functionsCalls.get(funcName).get(i));
                sb.append(" = ");
                sb.append(vars.get(functionsCalls.get(funcName).get(i)));
                sb.append(";");
            }
        }

        String variable = sb.toString();

        BufferedWriter codeWriter = new BufferedWriter((new FileWriter(fileName)));

        codeWriter.write(
                "package VM;\n" +
                "import com.sun.jna.Library;\n" +
                "import com.sun.jna.Native;\n" +
                "import com.sun.jna.Platform;\n" +
                "\n" +
                "public class GeneratedClass {\n" +
                "    public interface CLibrary extends Library {\n" +
                "        CLibrary INSTANCE = (CLibrary) Native.load(\n" +
                "                (Platform.isWindows() ? \"msvcrt\" : \""+  dllName +"\"), CLibrary.class);\n" +
                "        void printf(String format, Object... args);\n" +
                "    }\n" +
                "\n" +
                "    public static void main(String[] args) {\n"
                        + variable +
                "        CLibrary.INSTANCE."+ funcCall +";\n" +
                "    }\n" +
                "\n" +
                "}");
        codeWriter.flush();
        codeWriter.close();

    }

    private void compileCode() throws IOException {
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager fileManager = javac.getStandardFileManager(null, null, null);

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        Iterable<? extends JavaFileObject> compilationUnits1 = fileManager.getJavaFileObjectsFromFiles(Arrays
                .asList(new File[] { new File(fileName) }));

        javac.getTask(null, fileManager, diagnostics, null, null, compilationUnits1).call();

        for (Diagnostic diagnostic : diagnostics.getDiagnostics())
            System.out.println(diagnostic);

        fileManager.close();
    }


    private void runCode() {
        try {
            MyClassLoader loader = new MyClassLoader();

            //Class.forName("VM.generatedClassName")
            Class c = loader.getClassFromFile(new File(className));

            File file = new File("MyClass.class");

            Object o = c.newInstance();
            Method m = c.getMethod("main", new Class[] { String[].class });
            m.invoke(o, new Object[] { new String[0] });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    static class MyClassLoader extends ClassLoader {

        public Class getClassFromFile(File f) {
            byte[] raw = new byte[(int) f.length()];
            //System.out.println(f.length());
            InputStream in = null;
            try {
                in = new FileInputStream(f);
                in.read(raw);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return defineClass(null, raw, 0, raw.length);
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        String fileName = "MyClass.java";
        String className = "MyClass.class";
        File[] f = new File[] { new File(fileName), new File(className) };
        for (File file : f)
            file.delete();

        BufferedWriter fos = new BufferedWriter(new FileWriter(fileName));
        fos.write("import com.sun.jna.Library;\n" +
                "import com.sun.jna.Native;\n" +
                "import com.sun.jna.Platform;\n" +
                "\n" +
                "public class MyClass {\n" +
                "    public interface CLibrary extends Library {\n" +
                "        CLibrary INSTANCE = (CLibrary) Native.load(\n" +
                "                (Platform.isWindows() ? \"msvcrt\" : \"c\"), CLibrary.class);\n" +
                "        void printf(String format, Object... args);\n" +
                "    }\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        CLibrary.INSTANCE.printf(\"Hello, World\\n\");\n" +
                "    }\n" +
                "\n" +
                "}");
        fos.flush();
        fos.close();

        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = javac.getStandardFileManager(null, null, null);
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        Iterable<? extends JavaFileObject> compilationUnits1 = fileManager.getJavaFileObjectsFromFiles(Arrays
                .asList(new File[] { new File(fileName) }));
        javac.getTask(null, fileManager, diagnostics, null, null, compilationUnits1).call();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics())
            System.out.println(diagnostic);
        fileManager.close();


        try {
            MyClassLoader loader = new MyClassLoader();

            Class c = loader.getClassFromFile(new File(className));

            File file = new File("MyClass.class");

            Object o = c.newInstance();
            Method m = c.getMethod("main", new Class[] { String[].class });
            m.invoke(o, new Object[] { new String[0] });
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
