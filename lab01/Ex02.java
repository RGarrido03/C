import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sInScanner = new Scanner(System.in);
        Map<String, Double> variables = new HashMap<>();
        System.out.print(">>> ");

        while (sInScanner.hasNextLine()) {
            String exp1, exp2, token;
            double num2, result;

            Scanner sc = new Scanner(sInScanner.nextLine());

            // Expression 1
            if (sc.hasNext("[A-Za-z0-9]")) {
                exp1 = sc.next();
            } else {
                System.err.println("Expression 1 is not valid!");
                continue;
            }

            // Check if token exists
            if (!sc.hasNext()) {
                if (variables.containsKey(exp1)) {
                    System.out.println(variables.get(exp1));
                } else {
                    System.out.println("Warning: " + exp1 + " doesn't exist.");
                }
                continue;
            }

            // Token
            if (!sc.hasNext("[-+*/=]")) {
                System.err.println("Token is not valid!");
                continue;
            }
            token = sc.next();

            // Expression 2
            if (!sc.hasNext()) {
                System.err.println("Expression 2 doesn't exist!");
                continue;
            }
            exp2 = sc.nextLine();

            // Evaluate expression 2
            num2 = parseSecondExpression(exp2);
            if (Double.isNaN(num2)) {
                continue;
            }

            // Calculation
            if (token.equals("=") && exp1.matches("[A-Za-z]*")) {
                variables.put(exp1, num2);
                System.out.println(num2);
            } else {
                double num1 = Double.parseDouble(exp1);
                result = switch (token) {
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> num1 + num2;
                };
                System.out.println(result);
            }

            System.out.print(">>> ");
        }
    }

    private static double parseSecondExpression(String expr) {
        Scanner sc = new Scanner(expr);

        if (!sc.hasNextDouble()) {
            System.err.println("Expression 2 is invalid!");
            return Double.NaN;
        }
        double num1 = sc.nextDouble();

        if (!sc.hasNext()) {
            return num1;
        }

        if (!sc.hasNext("[-+*/]")) {
            System.err.println("Token after expression 2 is invalid!");
            return Double.NaN;
        }
        String token = sc.next();

        if (!sc.hasNextDouble()) {
            System.err.println("Expression 3 is invalid!");
            return Double.NaN;
        }
        double num2 = sc.nextDouble();

        if (sc.hasNext()) {
            System.out.println("Warning: Expression has more elements than supposed! Truncating.");
        }

        return switch (token) {
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> num1 + num2;
        };
    }
}
