
package cardgame;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * This FXMLDocumentController class is used to load the GUI element for the scene 'FourPlayerMode'
 * @author Wayile Jialade
 * @since 10/09/2017
 * @version 1.0
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void FourPlayerMode(ActionEvent event) throws IOException{
        Parent fourplayer = FXMLLoader.load(getClass().getResource("FourPlayerMode.fxml"));
        Scene fourplayerscene = new Scene(fourplayer);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(fourplayerscene);
        window.show();
    }
    
    
}
