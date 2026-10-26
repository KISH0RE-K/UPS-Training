
class SharedData {
    private int number;
    private boolean available = false;
    private boolean finished = false;

    synchronized void produce(int value) throws InterruptedException {
        while (available) {
            wait();
        }

        number = value;
        available = true;
        System.out.println("Produced: " + number);
        notifyAll();
    }

    synchronized void consume() throws InterruptedException {
        while (!available && !finished) {
            wait();
        }

        if (available) {
            System.out.println("Consumed: " + number);
            available = false;
            notifyAll();
        }
    }

    synchronized void finish() {
        finished = true;
        notifyAll();
    }

    synchronized boolean isFinished() {
        return finished && !available;
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        SharedData data = new SharedData();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    data.produce(i);
                }
                data.finish();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (!data.isFinished()) {
                    data.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        consumer.start();
        producer.start();

        producer.join();
        consumer.join();
    }
}
