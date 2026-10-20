
import java.rmi.*;
import java.rmi.server.*;

class Calculator extends UnicastRemoteObject
        implements assignment28q1interface {

    Calculator() throws RemoteException {
        super();
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) throws RemoteException {
        if (b == 0)
            throw new RemoteException("Cannot divide by zero");
        return (double) a / b;
    }
}

public class assignment28q1server {
    public static void main(String[] args) {
        try {
            Calculator c = new Calculator();
            Naming.rebind("Calculator", c);
            System.out.println("Calculator RMI Server is running.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
