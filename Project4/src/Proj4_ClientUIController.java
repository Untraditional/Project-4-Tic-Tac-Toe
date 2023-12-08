package new_proj4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Proj4_ClientUIController implements Initializable {

    @FXML
    private Button btn00,btn01,btn02,
            btn10,btn11,btn12,
            btn20,btn21,btn22;
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
            socket = new Socket(IP, PORT);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String message = reader.readLine();            
            lblPlayerSym.setText(message);

            // Start a separate thread to listen for messages from the server
            new Thread(this::receiveMessages).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    @FXML
    private void sendMoveHandler(ActionEvent event) throws IOException {
        clickedButton = (Button) event.getSource();
        if(clickedButton.getText().equals("")){
            //   You are player X
            String move = lblPlayerSym.getText().substring(15,16);
            clickedButton.setText(move);
            writer.println(move);
        }
        
        
        /*
        try {            
            clickedButton = (Button) event.getSource();
            String move;
            clickedButton.setText("X");
            if (lblPlayerSym.getText().equals("X")) {
                clickedButton.setText("X");
                move = clickedButton.getText();
                writer.println(move);                
            } 
            else if (lblPlayerSym.getText().equals("O")) {
                clickedButton.setText("O");
                move = clickedButton.getText();
                writer.println(move);                
            }            
            throw new IOException("Simulating IOException");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    
    private void receiveMessages() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                // Update the UI with the received message
                if(lblPlayerSym.getText().equals("X")){
                    clickedButton.setText("X");
                }
                else if(lblPlayerSym.getText().equals("O")){
                    clickedButton.setText("O");
                }                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    private void appendMessage(String message) {
        // Update the UI with the received message
        
        //lblPlayerSym.setText(message);
        if(message.equals("X")){
            clickedButton.setText("X");
        }
        else if(message.equals("O")){
            clickedButton.setText("O");
        }    
    }*/
}
