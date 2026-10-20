
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class assignment27q2client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5001);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(
            socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        String message;

        while (true) {
            System.out.print("Enter message: ");
            message = sc.nextLine();

            out.println(message);

            String reply = in.readLine();
            System.out.println("Server replied: " + reply);

            if (message.equalsIgnoreCase("exit"))
                break;
        }

        socket.close();
        sc.close();
    }
}
