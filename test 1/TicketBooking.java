
class TicketCounter {
    private int tickets = 10;

    synchronized void bookTickets(String customer, int requested) {
        if (tickets >= requested) {
            tickets -= requested;
            System.out.println(customer + " booked " + requested + " tickets");
        } else {
            System.out.println(customer + " booking failed. Available: " + tickets);
        }
    }

    synchronized int getTickets() {
        return tickets;
    }
}

class Customer extends Thread {
    private TicketCounter counter;

    Customer(TicketCounter counter, String name) {
        super(name);
        this.counter = counter;
    }

    public void run() {
        counter.bookTickets(getName(), 4);
    }
}

public class TicketBooking {
    public static void main(String[] args) throws InterruptedException {
        TicketCounter counter = new TicketCounter();

        Customer c1 = new Customer(counter, "Customer 1");
        Customer c2 = new Customer(counter, "Customer 2");
        Customer c3 = new Customer(counter, "Customer 3");

        c1.start();
        c2.start();
        c3.start();

        c1.join();
        c2.join();
        c3.join();

        System.out.println("Remaining tickets: " + counter.getTickets());
    }
}
