import java.util.Scanner;

public class assignment15q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter ATM PIN: ");
            int pin = sc.nextInt();

            if (pin != 1234) {
                throw new Exception("Invalid PIN!");
            }

            System.out.println("PIN Verified Successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("PIN verification process completed.");
        }

        sc.close();
    }
}