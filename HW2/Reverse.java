import java.util.ArrayList;
import java.util.Scanner;

public class Reverse {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<String>();

        while (input.hasNextLine()) {
            lines.add(input.nextLine());
        }

        for (int i = lines.size() - 1; i >= 0; i--) {
            String[] numbers = lines.get(i).split("\\p{javaWhitespace}");

            for (int j = numbers.length - 1; j >= 0; j--) {
                System.out.print(numbers[j] + " ");
            }

            System.out.println();
        }
    }
}
