import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sInScanner = new Scanner(System.in);
        Map<String, Double> variables = new HashMap<>();

        while (sInScanner.hasNextLine()) {
            double exp1 = 0, exp2 = 0, result = 0;
            String token = "", var = "", exp2Str = "";
            boolean isExp1Var = false, isExp2Var = false;

            Scanner sc = new Scanner(sInScanner.nextLine());

            // Expression 1
            if (sc.hasNextDouble()) {
                exp1 = sc.nextDouble();
            } else if (sc.hasNext("[A-Za-z]")) {
                var = sc.next();
                isExp1Var = true;
            } else {
                System.err.println("Expression 1 is not valid!");
                continue;
            }

            // Check if token exists
            if (!sc.hasNext()) {
                if (variables.containsKey(var)) {
                    System.out.println(variables.get(var));
                } else {
                    System.out.println("Warning: " + var + " doesn't exist.");
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
            if (sc.hasNextDouble()) {
                exp2 = sc.nextDouble();
            } else {
                isExp2Var = true;
                exp2Str = sc.nextLine();
            }

            // Calculation
            if (token.equals("=")) {
                variables.put(var, exp2);
                System.out.println(exp2);
            } else {
                result = switch (token) {
                    case "-" -> isExp1Var ? variables.get(var) - exp2 : exp1 - exp2;
                    case "*" -> isExp1Var ? variables.get(var) * exp2 : exp1 * exp2;
                    case "/" -> isExp1Var ? variables.get(var) / exp2 : exp1 / exp2;
                    default -> isExp1Var ? variables.get(var) + exp2 : exp1 + exp2;
                };
                System.out.println(result);
            }
        }
    }
}
