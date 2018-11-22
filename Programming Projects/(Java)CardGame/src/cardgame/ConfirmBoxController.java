/**
 * This ConfirmBoxController class is used to determine which interface should be displayed after players clicked 'yes' or 'no'
 * @author Wayile Jialade
 * @since 10/09/2017
 * @version 1.0
 */
package cardgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This ConfirmBoxController class is used to determine which interface should be displayed after players clicked 'yes' or 'no'
 * @author Wayile Jialade
 * @since 10/09/2017
 * @version 1.0
 */
public class ConfirmBoxController implements Initializable {

    @FXML
    private Button yesbutton;
    @FXML
    private Button nobutton;
    @FXML
    private Label winner;

    /**
     * Initializes the controller class.
     */
    
    
    
    @FXML
     public void YesButtonClicked(ActionEvent event) throws IOException{
        
        Stage close_window = (Stage) yesbutton.getScene().getWindow();
        close_window.close(); 
        
         
        Parent fourplayer = FXMLLoader.load(getClass().getResource("FourPlayerMode.fxml"));
        Scene fourplayerscene = new Scene(fourplayer);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(fourplayerscene);
        window.show();
        
    }
    
    @FXML
     public void NoButtonClicked(ActionEvent event) throws IOException{
        
        Stage close_window = (Stage) nobutton.getScene().getWindow();
        close_window.close(); 
        
         
        Parent fourplayer = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene fourplayerscene = new Scene(fourplayer);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(fourplayerscene);
        window.show();
    }
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        winner.setText(FourPlayerMode.winner);
    }    
    
}







