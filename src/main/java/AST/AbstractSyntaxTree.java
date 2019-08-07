package AST;

public interface AbstractSyntaxTree {

    Node getRoot();
    void build();
    void display(Node node);
    void display();
    void CSTBuild();
}
