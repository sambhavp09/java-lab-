
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class assignment27q1client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server!");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(
            socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        String message;

        while (true) {
            message = in.readLine();
            System.out.println("Server: " + message);

            if (message.equalsIgnoreCase("exit"))
                break;

            System.out.print("Client: ");
            message = sc.nextLine();
            out.println(message);

            if (message.equalsIgnoreCase("exit"))
                break;
        }

        socket.close();
        sc.close();
    }
}
