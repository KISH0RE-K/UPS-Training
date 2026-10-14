
abstract class Bank {
    abstract void interestRate();
}

class SBI extends Bank {
    void interestRate() {
        System.out.println("SBI interest rate is 7%");
    }
}

class IndianBank extends Bank {
    void interestRate() {
        System.out.println("Indian Bank interest rate is 8%");
    }
}

public class Main {
    public static void main(String[] args) {
        Bank b1 = new SBI();
        Bank b2 = new IndianBank();

        b1.interestRate();
        b2.interestRate();
    }
}
