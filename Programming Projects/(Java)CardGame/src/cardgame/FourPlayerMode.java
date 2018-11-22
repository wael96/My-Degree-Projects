
package cardgame;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * This FourPlayerMode class is used to manage labels and buttons of the Interface and act as main function of the Game Class
 * @author Wayile Jialade
 * @since 10/09/2017
 * @version 1.0
 */
public class FourPlayerMode implements Initializable {
    
    @FXML
    private Button button;
    @FXML
    private Label round_num;
    @FXML
    private Label win_count;
    @FXML
    private Label p1_cards;
    @FXML
    private Label p2_cards;
    @FXML
    private Label p3_cards;
    @FXML
    private Label p4_cards;
    @FXML
    private Label available_cards;
    @FXML
    private Label used_cards;
    @FXML
    private Label c_cards;
    @FXML
    private Label d_cards;
    @FXML
    private Label h_cards;
    @FXML
    private Label s_cards;
    @FXML
    public boolean status = true;
    public int i =1;
    
   
    
    public static String winner = "";
    
    public static Vector list_copy = new Vector();
    
    
    @FXML  
    /**
     * shows what displayed when you click the button"Start Playing"
     */
    private void handleButtonAction(ActionEvent event) throws IOException {
         
        Game game = new Game();
        
        //
        
        if(status==true){
            win_count.setText(game.display_wins_count());
            c_cards.setText(game.display_c_cards().toString());
            d_cards.setText(game.display_d_cards().toString());
            h_cards.setText(game.display_h_cards().toString());
            s_cards.setText(game.display_s_cards().toString());
        }
        status = false;
        if(i<=4){
            
            
            round_num.setText(Integer.toString(game.get_round_number()));
            System.out.println(round_num);
            game.give_card_to_player();
            p1_cards.setText(game.p1_cards_info().toString());
            p2_cards.setText(game.p2_cards_info().toString());
            p3_cards.setText(game.p3_cards_info().toString());
            p4_cards.setText(game.p4_cards_info().toString());
            c_cards.setText(game.display_c_cards().toString());
            d_cards.setText(game.display_d_cards().toString());
            h_cards.setText(game.display_h_cards().toString());
            s_cards.setText(game.display_s_cards().toString());
            win_count.setText(game.display_wins_count());
            available_cards.setText(game.arrange_vec_copy());
            System.out.println(list_copy);
            i++;
        }else{i=i+1;}
        if(i>5){
            game.isWinner(game.player1_wins_count,game.player2_wins_count,game.player3_wins_count,game.player4_wins_count);
            FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("ConfirmBox.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
            
            Stage close_window = (Stage) button.getScene().getWindow();
            close_window.hide(); 
            
            
            //reset all values to default after game finish
            game.round_number=0;
            game.display_c_cards().removeAllElements();
            game.display_d_cards().removeAllElements();
            game.display_h_cards().removeAllElements();
            game.display_s_cards().removeAllElements();
            game.player1_wins_count=0;
            game.player2_wins_count=0;
            game.player3_wins_count=0;
            game.player4_wins_count=0;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Game game = new Game();
        game.shufCards();
        list_copy = game.get_copy_of_list();
        available_cards.setText(game.arrange_vec_copy());
    }    
    
}

