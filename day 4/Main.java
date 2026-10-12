import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Student s = new Student(name, age, id);

        System.out.println("\nStudent Details:");
        s.displayDetails();

        sc.close();
    }
}