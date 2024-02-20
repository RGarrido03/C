import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sInScanner = new Scanner(System.in);
        Map<String, Double> variables = new HashMap<>();

        while (sInScanner.hasNextLine()) {
            String exp1, exp2, token;
            double result;

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
                System.err.println("Expression 2 is not valid!");
                continue;
            }
            exp2 = sc.next();

            // Calculation
            if (token.equals("=")) {
                variables.put(exp1, Double.parseDouble(exp2));
                System.out.println(exp2);
            } else {
                double num1 = Double.parseDouble(exp1);
                double num2 = Double.parseDouble(exp2);
                result = switch (token) {
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> num1 + num2;
                };
                System.out.println(result);
            }
        }
    }
}
