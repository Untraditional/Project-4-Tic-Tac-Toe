
package Project4;


import java.io.*;
import java.net.*;

public class client {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private final String HOST = "localhost";
    private final int PORT = 8000; // Same port as the server

    public client() {
        try {
            socket = new Socket(HOST, PORT);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
        }
    }

    // Method to send a move to the server
    public void sendMove(String move) {
        try {
            out.writeObject(move);
            out.flush();
        } catch (IOException e) {
        }
    }

    // Method to receive updates from the server
    public String receiveUpdate() {
        try {
            return (String) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        client client = new client();
        // Interaction with the server goes here
        // e.g., send moves, receive game updates
    }
}
