import java.util.ArrayList;
import java.util.Scanner;

public class ReverseSum {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int linesCount = 0;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            linesCount++;

            if (line.length() > 0) {
                String[] numbers = line.split("\\p{javaWhitespace}");

                ArrayList<Integer> integers = new ArrayList<Integer>();
                for (String number : numbers) {
                    integers.add(Integer.parseInt(number));
                }

                matrix.add(integers);
            } else {
                matrix.add(new ArrayList<Integer>());
            }
        }

        for (int i = 0; i < linesCount; i++) {
            int matrixSize = matrix.get(i).size();

            for (int j = 0; j < matrixSize; j++) {
                int sum = 0;
                
                for (int t = 0; t < matrixSize; t++) {
                    sum += matrix.get(i).get(t);
                }

                for (int t = 0; t < linesCount; t++) {
                    if (matrix.get(t).size() > j && i != t) {
                        sum += matrix.get(t).get(j);
                    }
                }

                System.out.print(sum + " ");
            }

            System.out.println();
        }
    }
}
