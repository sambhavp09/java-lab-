
import java.net.*;
import java.io.*;

public class assignment27q2server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5001);
        System.out.println("Echo server waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(
            socket.getOutputStream(), true);

        String message;

        while ((message = in.readLine()) != null) {
            System.out.println("Client sent: " + message);

            out.println(message);

            if (message.equalsIgnoreCase("exit"))
                break;
        }

        socket.close();
        server.close();
    }
}
