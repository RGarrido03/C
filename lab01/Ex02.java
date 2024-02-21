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
                System.out.print(">>> ");
                continue;
            }

            // Check if token exists
            if (!sc.hasNext()) {
                if (variables.containsKey(exp1)) {
                    System.out.println(variables.get(exp1));
                } else {
                    System.out.println("Warning: " + exp1 + " doesn't exist.");
                }
                System.out.print(">>> ");
                continue;
            }

            // Token
            if (!sc.hasNext("[-+*/=]")) {
                System.err.println("Token is not valid!");
                System.out.print(">>> ");
                continue;
            }
            token = sc.next();

            // Expression 2
            if (!sc.hasNext()) {
                System.err.println("Expression 2 doesn't exist!");
                System.out.print(">>> ");
                continue;
            }
            exp2 = sc.nextLine();

            // Evaluate expression 2
            num2 = parseSecondExpression(exp2, variables);
            if (Double.isNaN(num2)) {
                System.out.print(">>> ");
                continue;
            }

            // Calculation
            if (token.equals("=") && exp1.matches("[A-Za-z]*")) {
                variables.put(exp1, num2);
                System.out.println(num2);
            } else {
                double num1 = Double.parseDouble(exp1);
                result = calculate(num1, token, num2);
                System.out.println(result);
            }

            System.out.print(">>> ");
        }
    }

    private static Double parseNumberOrVariable(Scanner sc, Map<String, Double> variables) {
        if (sc.hasNextDouble()) {
            return sc.nextDouble();
        }
        if (sc.hasNext("[a-zA-Z]*")) {
            String var = sc.next();
            if (variables.containsKey(var)) {
                return variables.get(var);
            }
            System.err.println("Variable " + var + " doesn't exist.");
            return Double.NaN;
        }
        System.err.println("Expression invalid.");
        return Double.NaN;
    }

    private static double calculate(double num1, String token, double num2) {
        return switch (token) {
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> num1 + num2;
        };
    }

    private static double parseSecondExpression(String expr, Map<String, Double> variables) {
        Scanner sc = new Scanner(expr);

        Double num1 = parseNumberOrVariable(sc, variables);
        if (num1.isNaN() || !sc.hasNext()) {
            return num1;
        }

        if (!sc.hasNext("[-+*/]")) {
            System.err.println("Token after expression 2 is invalid!");
            return Double.NaN;
        }
        String token = sc.next();

        Double num2 = parseNumberOrVariable(sc, variables);
        if (num2.isNaN()) {
            return num2;
        }

        if (sc.hasNext()) {
            System.out.println("Warning: Expression has more elements than supposed! Truncating.");
        }

        return calculate(num1, token, num2);
    }
}
