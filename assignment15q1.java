import java.util.Scanner;

public class assignment15q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (!password.equals("java123")) {
                throw new Exception("Invalid Password!");
            }

            System.out.println("Login Successful");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Login process completed.");
        }

        sc.close();
    }
}