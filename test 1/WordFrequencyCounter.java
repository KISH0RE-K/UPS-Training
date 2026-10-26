
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String sentence = "java is easy and java is powerful";
        HashMap<String, Integer> map = new HashMap<>();

        if (sentence == null || sentence.trim().isEmpty()) {
            System.out.println("Empty sentence");
            return;
        }

        String[] words = sentence.toLowerCase().trim().split("\\s+");

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println(map);

        String mostFrequent = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequent = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        System.out.println("Most frequent word: " + mostFrequent);
        System.out.println("Frequency: " + maxCount);
    }
}
