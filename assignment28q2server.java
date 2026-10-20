
import java.rmi.*;
import java.rmi.server.*;

class TemperatureConverter extends UnicastRemoteObject
        implements assignment28q2interface {

    TemperatureConverter() throws RemoteException {
        super();
    }

    public double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
}

public class assignment28q2server {
    public static void main(String[] args) {
        try {
            TemperatureConverter t = new TemperatureConverter();
            Naming.rebind("Temperature", t);
            System.out.println("Temperature RMI Server is running.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
