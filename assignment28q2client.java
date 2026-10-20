
import java.rmi.*;
import java.util.Scanner;

public class assignment28q2client {
    public static void main(String[] args) {
        try {
            assignment28q2interface t =
                (assignment28q2interface)
                Naming.lookup("rmi://localhost/Temperature");

            Scanner sc = new Scanner(System.in);

            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            System.out.print("Enter temperature: ");
            double temp = sc.nextDouble();

            if (choice == 1) {
                System.out.println("Fahrenheit: "
                    + t.celsiusToFahrenheit(temp));
            } else if (choice == 2) {
                System.out.println("Celsius: "
                    + t.fahrenheitToCelsius(temp));
            } else {
                System.out.println("Invalid choice.");
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
