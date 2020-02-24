import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordStatCount {
    private static class Word implements Comparable {
        int count, firstEnter;
        String word;

        Word(int count, int firstEnter, String word) {
            this.count = count;
            this.firstEnter = firstEnter;
            this.word = word;
        }

        @Override
        public int compareTo(Object object) {
            Word word = (Word) object;

            if ((this.count < word.count) || (this.count == word.count && this.firstEnter < word.firstEnter)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        try (
                Scanner input = new Scanner(new File(args[0]), StandardCharsets.UTF_8);
                PrintWriter output = new PrintWriter(new File(args[1]), StandardCharsets.UTF_8)
        ) {
            Map<String, Integer> countWord = new HashMap<>();
            Map<String, Integer> firstEnter = new HashMap<>();
            int counter = 0;

            while (input.hasNextLine()) {
                String string = input.nextLine();
                String[] words = string.split("[^\\p{L}\\p{Pd}']+");

                for (String word : words) {
                    word = word.toLowerCase();

                    if (countWord.containsKey(word)) {
                        countWord.put(word, countWord.get(word) + 1);
                    } else if (word.length() > 0) {
                        firstEnter.put(word, counter++);
                        countWord.put(word, 1);
                    }
                }
            }

            ArrayList<Word> words = new ArrayList<>();
            for (Map.Entry<String, Integer> count : countWord.entrySet()) {
                words.add(new Word(count.getValue(), firstEnter.get(count.getKey()), count.getKey()));
            }

            Collections.sort(words);
            for (Word word : words) {
                output.println(word.word + " " + word.count);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
