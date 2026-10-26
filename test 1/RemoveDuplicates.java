
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 20, 40, 50, 30};
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        System.out.println("Unique values: " + set);
        System.out.println("Number of unique elements: " + set.size());
        System.out.println("Contains 40: " + set.contains(40));
    }
}
