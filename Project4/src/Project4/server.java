
package Project4;

import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    private ServerSocket serverSocket;
    private final int PORT = 8000; // Port number for the server
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public server() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                out = new ObjectOutputStream(clientSocket.getOutputStream());
                in = new ObjectInputStream(clientSocket.getInputStream());

                // Handle game logic here
                // e.g., read client's move, update game state, send response

            } catch (IOException e) {
            } finally {
                try {
                    clientSocket.close();
                    in.close();
                    out.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        server server = new server();
        server.listen();
    }
}
