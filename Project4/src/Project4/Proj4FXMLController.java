package proj4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Proj4FXMLController implements Initializable {

    @FXML
    private Button m00,m01,m02,m10,m11,m12,m20,m21,m22;
    @FXML
    private Label lblWinner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    @FXML
    private void handleCLick(ActionEvent event) {
        //currently psuedocode
        if(player1 && Button clickedButton = (Button) event.getSource()){
            button.setText("X");
        }
        //about the same for player2's turn but with "O"'s
        
        
    }
    
    //Also still psuedocode, but just throwing ideas out
    //maybe not use boolean? 
    //just check and output winner to the GUI
    private boolean winnerCheck(){
        if(m00,m01,m02 == "X")
            
        return false;
        
    }
}
