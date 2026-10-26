public class SecondLargestDistinct {
    public static void main(String[] args) {
        int[] arr = {12, 45, 7, 45, 32, 18};
        Integer largest = null;
        Integer secondLargest = null;

        for (int num : arr) {
            if (largest == null || num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num < largest &&
                    (secondLargest == null || num > secondLargest)) {
                secondLargest = num;
            }
        }

        if (secondLargest == null) {
            System.out.println("No second-largest distinct element");
        } else {
            System.out.println("Second largest: " + secondLargest);
        }
    }
}