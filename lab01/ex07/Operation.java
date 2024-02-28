package ex07;

public class Operation extends Node {
    private final String operation;
    private Node left;
    private Node right;

    public Operation(String operation, Node parent, Node left, Node right) {
        super(parent);
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public Operation(String operation, Node parent) {
        this(operation, parent, null, null);
    }

    public Operation(String operation) {
        this(operation, null, null, null);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operation='" + operation + '\'' +
                '}';
    }

    public String getOperation() {
        return this.operation;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
