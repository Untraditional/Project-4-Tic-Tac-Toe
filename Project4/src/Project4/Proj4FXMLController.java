
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
    private Button m00;
    @FXML
    private Button m01;
    @FXML
    private Button m02;
    @FXML
    private Button m10;
    @FXML
    private Button m11;
    @FXML
    private Button m12;
    @FXML
    private Button m20;
    @FXML
    private Button m21;
    @FXML
    private Button m22;
    @FXML
    private Label lblWinner;

    /**
     * Initializes the controller class.
     */
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
