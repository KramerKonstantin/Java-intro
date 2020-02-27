import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordStatLineIndex {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Expected 2 arguments");
            return;
        }

        try (
                Scanner input = new Scanner(new File(args[0]), StandardCharsets.UTF_8);
                PrintWriter output = new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))
        ) {
            Map<String, ArrayList<Integer>> indexWords = new HashMap<>();
            Map<String, ArrayList<Integer>> lineWords = new HashMap<>();
            ArrayList<String> words = new ArrayList<>();

            int line = 0;
            int position;
            while (input.hasNextLine()) {
                String string = input.nextLine();
                String[] wordsInLine = string.split("[^\\p{L}\\p{Pd}']+");
                line++;
                position = 0;

                for (String s : wordsInLine) {
                    String word = s.toLowerCase();

                    if (word.isEmpty()) {
                        continue;
                    }

                    position++;

                    if (!indexWords.containsKey(word)) {
                        indexWords.put(word, new ArrayList<>());
                        lineWords.put(word, new ArrayList<>());
                        words.add(word);
                    }

                    indexWords.get(word).add(position);
                    lineWords.get(word).add(line);
                }
            }

            Collections.sort(words);

            for (String word : words) {
                output.write(word + " " + indexWords.get(word).size());

                for (int i = 0; i < indexWords.get(word).size(); i++) {
                    output.write(" " + lineWords.get(word).get(i) + ":" + indexWords.get(word).get(i));
                }

                output.write("\n");
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
