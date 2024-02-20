import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sInScanner = new Scanner(System.in);

        while (sInScanner.hasNextLine()) {
            double exp1, exp2, result;
            String token;

            Scanner sc = new Scanner(sInScanner.nextLine());

            if (sc.hasNextDouble()) {
                exp1 = sc.nextDouble();
            } else {
                System.err.println(sc.next() + " is not a double!");
                continue;
            }

            if (sc.hasNext("[-+*/]")) {
                token = sc.next();
            } else {
                System.err.println(sc.next() + " is not a valid token!");
                continue;
            }

            if (sc.hasNextDouble()) {
                exp2 = sc.nextDouble();
            } else {
                System.err.println(sc.next() + " is not a double!");
                continue;
            }

            if (sc.hasNext()) {
                System.out.println("Warning: There are more expressions than supposed!");
            }

            result = switch (token) {
                case "-" -> exp1 - exp2;
                case "*" -> exp1 * exp2;
                case "/" -> exp1 / exp2;
                default -> exp1 + exp2;
            };

            System.out.println(result);
        }
    }
}
