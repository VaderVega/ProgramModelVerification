package VM;

import Compilation.CodeGenerator;

import java.util.List;

public interface VirtualMachine {

    void run(final List<String> program);

}
