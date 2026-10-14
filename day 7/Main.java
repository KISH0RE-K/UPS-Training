import java.util.Scanner;

interface Payment {
    void pay();
}

class UPI implements Payment {
    public void pay() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter UPI PIN: ");
        int pin = sc.nextInt();
        System.out.println("UPI payment successful");
    }
}

class Cash implements Payment {
    public void pay() {
        System.out.println("Cash payment received");
    }
}

class Card implements Payment {
    public void pay() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter card number: ");
        String cardNo = sc.nextLine();
        System.out.println("Card payment successful");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. UPI");
        System.out.println("2. Cash");
        System.out.println("3. Card");
        System.out.print("Choose payment method: ");

        int choice = sc.nextInt();

        Payment p;

        switch (choice) {
            case 1:
                p = new UPI();
                break;
            case 2:
                p = new Cash();
                break;
            case 3:
                p = new Card();
                break;
            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        p.pay();
    }
}
