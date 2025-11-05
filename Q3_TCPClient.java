

import java.io.*;
import java.net.*;

public class Q3_TCPClient {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 12345;
        String message = "Hello from Prashant";

        try (Socket socket = new Socket(serverHost, serverPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to server. Sending: " + message);
            out.println(message);
            String response = in.readLine();
            System.out.println("Server replied: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
