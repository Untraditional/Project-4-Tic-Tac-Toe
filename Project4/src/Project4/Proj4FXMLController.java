
package proj4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

/**
 * FXML Controller class
 *
 * @author dhall
 */
public class Proj4FXMLController implements Initializable {

    @FXML
    private ToggleButton m00;
    @FXML
    private ToggleButton m01;
    @FXML
    private ToggleButton m02;
    @FXML
    private ToggleButton m10;
    @FXML
    private ToggleButton m11;
    @FXML
    private ToggleButton m12;
    @FXML
    private ToggleButton m20;
    @FXML
    private ToggleButton m21;
    @FXML
    private ToggleButton m22;
    @FXML
    private Label lblWinner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    @FXML
    private void handleCLick(ActionEvent event) {
        if(m00.isSelected()){
            m00.setText("X");
        }
        if(m01.isSelected()){
            m01.setText("O");
        }
    }
    
}
