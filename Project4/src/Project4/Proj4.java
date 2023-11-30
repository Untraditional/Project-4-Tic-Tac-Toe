
package proj4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Proj4 extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {      
        
        Parent root = FXMLLoader.load(getClass().getResource("Proj4FXML.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
