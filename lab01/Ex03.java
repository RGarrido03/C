import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Ex03 {
    private static final Deque<Double> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(">> ");

        outerloop:
        while (sc.hasNextLine()) {
            Scanner sc2 = new Scanner(sc.nextLine());

            while (sc2.hasNext()) {
                if (sc2.hasNext("exit")) {
                    return;
                }

                if (sc2.hasNextDouble()) {
                    deque.push(sc2.nextDouble());
                    continue;
                }

                if (sc2.hasNext("[-+*/]")) {
                    double num1 = deque.pop();
                    double num2 = deque.pop();

                    double result = switch (sc2.next()) {
                        case "-" -> num1 - num2;
                        case "*" -> num1 * num2;
                        case "/" -> num1 / num2;
                        default -> num1 + num2;
                    };
                    deque.push(result);
                    continue;
                }

                System.out.println("Token " + sc2.next() + " is not valid!");
                System.out.print(">> ");
                continue outerloop;
            }

            System.out.println(deque.pop());
            System.out.print(">> ");
        }
    }
}
