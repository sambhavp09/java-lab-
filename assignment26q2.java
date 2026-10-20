class BankAccount {

    int balance = 1000;

    synchronized void deposit(int amount) {

        balance += amount;

        System.out.println(
            "Deposited: " + amount +
            " | Balance: " + balance
        );
    }

    synchronized void withdraw(int amount) {

        if (balance >= amount) {

            balance -= amount;

            System.out.println(
                "Withdrawn: " + amount +
                " | Balance: " + balance
            );

        } else {

            System.out.println(
                "Withdrawal failed. Insufficient balance."
            );
        }
    }
}

class DepositTask implements Runnable {

    BankAccount account;

    DepositTask(BankAccount account) {
        this.account = account;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            account.deposit(500);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class WithdrawTask implements Runnable {

    BankAccount account;

    WithdrawTask(BankAccount account) {
        this.account = account;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            account.withdraw(300);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class assignment26q2 {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread depositThread =
            new Thread(new DepositTask(account));

        Thread withdrawThread =
            new Thread(new WithdrawTask(account));

        depositThread.start();
        withdrawThread.start();
    }
}