
import java.rmi.*;

public interface assignment28q2interface extends Remote {
    double celsiusToFahrenheit(double c)
        throws RemoteException;

    double fahrenheitToCelsius(double f)
        throws RemoteException;
}
