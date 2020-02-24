import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordStatInput {
    public static void main(String[] args) {
        try (
                Scanner input = new Scanner(new File(args[0]), StandardCharsets.UTF_8);
                PrintWriter output = new PrintWriter(new File(args[1]), StandardCharsets.UTF_8)
        ) {
            Map<String, Integer> countWord = new HashMap<>();
            ArrayList<String> allWord = new ArrayList<>();

            while (input.hasNextLine()) {
                String string = input.nextLine();
                String[] words = string.split("[^\\p{L}\\p{Pd}']+");

                for (String s : words) {
                    String word = s.toLowerCase();

                    if (countWord.containsKey(word)) {
                        countWord.put(word, countWord.get(word) + 1);
                    } else if (word.length() > 0) {
                        allWord.add(word);
                        countWord.put(word, 1);
                    }
                }
            }

            for (String word : allWord) {
                output.println(word + " " + countWord.get(word));
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
