class BankAccount {
    final int accountNumber = 123456;
    String name = "Sambhav";
    double balance = 5000;

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: " + balance);
    }
}

public class assignment9q1 {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        b.display();
    }
}