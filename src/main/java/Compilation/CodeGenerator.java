package Compilation;

import AST.AbstractSyntaxTree;

import java.util.List;

public interface CodeGenerator {
    List<String> compile(final AbstractSyntaxTree tree);

    /**
     * IFETCH x - положить на стек значение переменной x
     * ISTORE x - сохранить в переменной x значение с вершины стека
     * IPUSH  n - положить число n на вершину стека
     * IPOP     - удалить число с вершины стека
     * IADD     - сложить два числа на вершине стека
     * ISUB     - вычесть два числа на вершине стека
     * DREM     - взять остаток от деления двух чисел на вершине стека
     * ILT      - сравнить два числа с вершины стека (a < b). Результат - 0 или 1
     * IGT      - сравнить два числа с вершины стека (a > b). Результат - 0 или 1
     * INE      - сравнить два числа с вершины стека (a != b). Результат - 0 или 1
     * JZ    a - если на вершине стека 0 - перейти к адресу a.
     * JMP   a - перейти к адресу a
     * FUNC    - вызов функции
     * HALT    - завершить работу
     */
    enum Instruction {
        IFETCH, ISTORE, IPUSH, IPOP, IADD, ISUB, DREM, ILT, IGT, INE, JZ, JMP, IFUNC, ICLASS, IFUNCCALL, IFUNCPARAM, IDLL, HALT
    }
}
