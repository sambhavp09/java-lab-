import java.util.Scanner;

class LicenseAgeException extends Exception {
    LicenseAgeException(String message) {
        super(message);
    }
}

public class assignment16q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            if (age < 18) {
                throw new LicenseAgeException("You are not eligible for a driving license.");
            }

            System.out.println("You are eligible for a driving license.");

        } catch (LicenseAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}