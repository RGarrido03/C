package ex07;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            Scanner sc2 = new Scanner(sc.nextLine());
            Node root = createPrefix(sc2, null, null);

            if (root == null) {
                continue;
            }

            printTree(root);

            printInfix(root);
            System.out.print(" = ");

            System.out.println(eval(root));
        }
    }

    private static Node createPrefix(Scanner sc, Operation parent, Direction direction) {
        if (!sc.hasNext()) {
            return null;
        }

        if (sc.hasNextInt()) {
            Node n = new Number(sc.nextInt(), parent);
            if (parent != null) {
                if (direction == Direction.LEFT) {
                    parent.setLeft(n);
                } else {
                    parent.setRight(n);
                }
            }
            createPrefix(sc, parent, Direction.RIGHT);
            return n;
        }

        if (!sc.hasNext("[-+*/]")) {
            System.err.println(sc.next() + " is not a valid operation!");
            return null;
        }
        Operation op = new Operation(sc.next(), parent);

        if (parent != null) {
            parent.setRight(op);
        }
        createPrefix(sc, op, Direction.LEFT);
        return op;
    }

    private static void printTree(Node root) {
        if (root == null) {
            System.err.println("Root is null");
            return;
        }

        System.out.println(root);

        if (root.getClass() == Operation.class) {
            printTree(((Operation) root).getLeft());
            printTree(((Operation) root).getRight());
        }
    }

    private static void printInfix(Node root) {
        if (root.getClass() == Operation.class) {
            Operation op = (Operation) root;

            System.out.print("(");
            printInfix(op.getLeft());
            System.out.print(op.getOperation());
            printInfix(op.getRight());
            System.out.print(")");
        } else {
            Number num = (Number) root;
            System.out.print(num.getValue());
        }
    }

    private static double eval(Node root) {
        if (root.getClass() == Operation.class) {
            Operation op = (Operation) root;
            double left = eval(op.getLeft());
            double right = eval(op.getRight());

            return switch (op.getOperation()) {
                case "-" -> left - right;
                case "*" -> left * right;
                case "/" -> left / right;
                default -> left + right;
            };
        } else {
            Number num = (Number) root;
            return num.getValue();
        }
    }
}
