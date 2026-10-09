import java.util.*;

class For {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        num = num % 2;

        switch (num) {
            case 0:
                System.out.println("even");
                break;

            case 1:
                System.out.println("odd");
                break;
        }
    }
}