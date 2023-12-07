
package new_proj4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Proj4_ClientUIController implements Initializable {

    @FXML
    private Button btn00,btn01,btn02,btn10,btn11,btn12,btn20,btn21,btn22;
    @FXML
    private Label lblPlayerSym;
    @FXML
    private Label lblWinner;
    
    private Button clickedButton;
    
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    
    private static final int PORT = 5454;
    private static final String IP = "localhost";

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Initialize the socket connection here
        try {
            // Replace "localhost" and 12345 with your server's address and port
            socket = new Socket(IP, 5454);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Start a separate thread to listen for messages from the server
            new Thread(this::receiveMessages).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    @FXML
    private void sendMoveHandler(ActionEvent event) {
        try {
            String message = reader.readLine();
            lblPlayerSym.setText("You are: " + message);
            
            clickedButton = (Button) event.getSource();
            String move;
            
            if (clickedButton.getText().equals("") && lblPlayerSym.getText().equals("X")) {
                clickedButton.setText("X");
                move = clickedButton.getText();
                writer.println(move);                
            } 
            else if (clickedButton.getText().equals("") && lblPlayerSym.getText().equals("O")) {
                clickedButton.setText("O");
                move = clickedButton.getText();
                writer.println(move);                
            }            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void receiveMessages() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                // Update the UI with the received message
                appendMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void appendMessage(String message) {
        // Update the UI with the received message
        
        lblPlayerSym.setText(message);
        if(message == "X"){
            clickedButton.setText("X");
        }
        else if(message == "O"){
            clickedButton.setText("O");
        }    
    }    
}
