import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);

    public static int[][] inputMatrix() {
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] a = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        return a;
    }

    public static int findSum(int[][] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
        }
        return sum;
    }

    public static void showResult(int sum) {
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[][] a = inputMatrix();
        int sum = findSum(a);
        showResult(sum);

        sc.close();
    }
}