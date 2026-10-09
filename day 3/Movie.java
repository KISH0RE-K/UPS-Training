import java.util.Scanner;

public class Movie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Movie Ticket Booking ===");
	System.out.println("Avengers doomsday");
	System.out.println("Dune");
	System.out.println("Endgame Encore");

        System.out.print("Enter movie name: ");
        String movie = sc.nextLine();

        System.out.print("Enter number of tickets: ");
        int tickets = sc.nextInt();

        int price=0;

        if (movie.equals("Avengers doomsday")) {
            price = 200;
        }
        else if (movie.equals("Dune")) {
            price = 180;
        }
        else if (movie.equals("Endgame Encore")) {
            price = 150;
        }
        else {
            System.out.println("Movie not available.");
            return;
        }

        if (tickets > 0) {

            int total = tickets * price;

            if (tickets > 5) {
                total = total - (tickets*10);
            }

            System.out.println("Booking Successful!");
            System.out.println("Movie: " + movie);
            System.out.println("Tickets: " + tickets);
            System.out.println("Total Price: " + total);
        }
        else {
            System.out.println("Invalid number of tickets.");
        }

    }
}