import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordStatIndex {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Expected 2 arguments");
            return;
        }

        try (
                Scanner input = new Scanner(new File(args[0]), StandardCharsets.UTF_8);
                PrintWriter output = new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))
        ) {
            Map<String, ArrayList<Integer>> statWords = new HashMap<>();
            ArrayList<String> words = new ArrayList<>();

            int position = 0;
            while (input.hasNextLine()) {
                String string = input.nextLine();
                String[] wordsInLine = string.split("[^\\p{L}\\p{Pd}']+");

                for (String s : wordsInLine) {
                    String word = s.toLowerCase();

                    if (word.isEmpty()) {
                        continue;
                    }

                    position++;
                    if (!statWords.containsKey(word)) {
                        statWords.put(word, new ArrayList<>());
                        words.add(word);
                    }

                    statWords.get(word).add(position);
                }
            }

            for (String word : words) {
                output.write(word + " " + statWords.get(word).size());

                for (Integer index : statWords.get(word)) {
                    output.write(" " + index);
                }

                output.write("\n");
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
