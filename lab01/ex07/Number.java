package ex07;

public class Number extends Node {
    private final int value;

    public Number(int value, Node parent) {
        super(parent);
        this.value = value;
    }

    public Number(int value) {
        this(value, null);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                '}';
    }
}
