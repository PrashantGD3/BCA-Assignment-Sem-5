


import java.io.*;
import java.net.*;

public class Q3_TCPServer {
    public static void main(String[] args) {
        int port = 12345;
        System.out.println("TCP Server starting on port " + port + " ...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting for client...");
            try (Socket client = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                System.out.println("Client connected: " + client.getInetAddress());
                String received = in.readLine();
                System.out.println("Received (original): " + received);

                String processed = received == null ? "" : received.toUpperCase();
                System.out.println("Processed (to upper-case): " + processed);


                out.println(processed);
                System.out.println("Processed message sent back to client. Closing connection.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
