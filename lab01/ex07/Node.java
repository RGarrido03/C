package ex07;

public abstract class Node {
    private Node parent;

    public Node() {
    }

    public Node(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "parent=" + parent +
                '}';
    }
}
