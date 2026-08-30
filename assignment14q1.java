import java.util.Scanner;

public class assignment14q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter withdrawal amount: ");
            int amount = sc.nextInt();

            if (amount <= 0) {
                throw new Exception("Invalid withdrawal amount!");
            }

            System.out.println("Withdrawal successful: " + amount);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}