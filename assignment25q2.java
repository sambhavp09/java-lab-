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

class DepositThread extends Thread {

    BankAccount account;

    DepositThread(BankAccount account) {
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

class WithdrawThread extends Thread {

    BankAccount account;

    WithdrawThread(BankAccount account) {
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

public class assignment25q2 {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        DepositThread deposit = new DepositThread(account);
        WithdrawThread withdraw = new WithdrawThread(account);

        deposit.start();
        withdraw.start();
    }
}