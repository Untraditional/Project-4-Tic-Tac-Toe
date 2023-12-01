/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Project4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class TicTacFXMLController implements Initializable {

    @FXML
    private Button m00, m01, m02, m10, m11, m12, m20, m21, m22;
    
    @FXML
    private Label lblWinner;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    @FXML
    private void handleCLick(ActionEvent event) {
        if (m00.getText().equals("")) {
            m00.setText("X");
        } 
        else if (m01.getText().equals("")) {
            m01.setText("O");
        }
        else if (m02.getText().equals("") ) {
            m02.setText("O");
        }
        
    }
    
    private boolean winnerCheck(){
        return true;
    }
    
}
