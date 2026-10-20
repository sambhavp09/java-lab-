
import java.rmi.*;
import java.util.Scanner;

public class assignment28q1client {
    public static void main(String[] args) {
        try {
            assignment28q1interface c =
                (assignment28q1interface)
                Naming.lookup("rmi://localhost/Calculator");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.println("Addition: " + c.add(a, b));
            System.out.println("Subtraction: " + c.subtract(a, b));
            System.out.println("Multiplication: " + c.multiply(a, b));

            if (b != 0)
                System.out.println("Division: " + c.divide(a, b));
            else
                System.out.println("Division by zero is not allowed.");

            sc.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
