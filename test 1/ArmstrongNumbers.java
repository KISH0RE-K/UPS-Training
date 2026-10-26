public class ArmstrongNumbers {
    public static void main(String[] args) {
        for (int num = 1; num <= 1000; num++) {
            int n = num;
            int digits = 0;
            int sum = 0;

            while (n > 0) {
                digits++;
                n /= 10;
            }

            n = num;

            while (n > 0) {
                int digit = n % 10;
                int power = 1;

                for (int i = 0; i < digits; i++) {
                    power *= digit;
                }

                sum += power;
                n /= 10;
            }

            if (sum == num) {
                System.out.print(num + " ");
            }
        }
    }
}