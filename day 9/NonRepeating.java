
import java.util.*;

class NonRepeating {
    public static void main(String[] args) {
        String s = "aabbcde";

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                System.out.println(ch);
                return;
            }
        }

        System.out.println("No non-repeating character");
    }
}
