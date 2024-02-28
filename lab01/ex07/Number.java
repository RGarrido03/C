package ex07;

public class Number extends Node {
    private final double value;

    public Number(double value, Node parent) {
        super(parent);
        this.value = value;
    }

    public Number(double value) {
        this(value, null);
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                '}';
    }
}
