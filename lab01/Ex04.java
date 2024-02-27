import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex04 {
    private static final Map<String, Integer> map = new HashMap<>();
    private static final String FILENAME = "numbers.txt";

    public static void main(String[] args) {
        try {
            readNumbersFile();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("[- +\n]");
        while (sc.hasNext()) {
            String word = sc.next();

            if (map.containsKey(word)) {
                System.out.print(map.get(word) + " ");
                continue;
            }
            System.out.print(word + " ");
        }
    }

    private static void readNumbersFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(FILENAME));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Scanner sc2 = new Scanner(line);
            int number;
            String extended;

            if (!sc2.hasNextInt()) {
                throw new IllegalArgumentException(sc.next() + " is not a number!");
            }
            number = sc2.nextInt();

            if (!sc2.hasNext("[-]")) {
                throw new IllegalArgumentException("'-' is expected!");
            }
            sc2.next();

            if (!sc2.hasNext()) {
                throw new IllegalArgumentException("Extended number is expected!");
            }
            extended = sc2.next();

            map.put(extended, number);
        }
    }
}
