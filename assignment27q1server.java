
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class assignment27q1server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(
            socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        String message;

        while (true) {
            System.out.print("Server: ");
            message = sc.nextLine();
            out.println(message);

            if (message.equalsIgnoreCase("exit"))
                break;

            message = in.readLine();
            System.out.println("Client: " + message);

            if (message.equalsIgnoreCase("exit"))
                break;
        }

        socket.close();
        server.close();
        sc.close();
    }
}
