
package cardgame;

import static cardgame.FourPlayerMode.winner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import static cardgame.FourPlayerMode.list_copy;

/**
 * This Game class is used to create all necessary function involved during the game
 * @author Wayile Jialade
 * @since 10/09/2017
 * @version 1.0
 */
public class Game extends FourPlayerMode{
    
    Random random = new Random();
    protected static int round_number=0;
    protected static int player1_wins_count,player2_wins_count,player3_wins_count,player4_wins_count = 0;
    protected int player1_score,player2_score,player3_score,player4_score;
    String color;
    String card_number;
    protected List<Game> list = new ArrayList<Game>();
    
    protected static Vector<String> c_card_list = new Vector<>();
    protected static Vector<String> d_card_list = new Vector<>();
    protected static Vector<String> h_card_list = new Vector<>();
    protected static Vector<String> s_card_list = new Vector<>();
    
    protected Vector copy_player1_cards = new Vector();
    protected Vector copy_player2_cards = new Vector();
    protected Vector copy_player3_cards = new Vector();
    protected Vector copy_player4_cards = new Vector();
    
    protected String player1_info,player2_info,player3_info,player4_info;
    
    public Game(){
        
            System.out.println("Sample run:");
            String[] color = {"D", "C", "H", "S"};
            String[] number = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10", "J","Q","K"};
            
            //easy method to generate all possible combination of cards
            
            for(int i=0;i<color.length;i++){
                for(int j=0;j<number.length;j++){
                    list.add(new Game(color[i], number[j]));
                }
            }
    }
    
    /**
     * This method is used to assign color and card_number
     * @param color this is used to store color e.g D,C,H,S
     * @param card_number this is used to store card_number e.g A,2,3,4,5,6,7,8,9,10,J,Q,K
     */
    public Game(String color, String card_number) {
        this.color = color;
        this.card_number = card_number;
    }
    
    /**
     * This is method is used to get the list of available cards
     * @return this is used to return the current list of the available cards
     */
    public List<Game> getList() {
        return list;
    }
    
    /**
     * This method is used to get the color of the cards
     * @return this is used to return the color of current card
     */
    public String getColor() {
        return color;
    }
    
    /**
     * This method is used to get the number of the cards
     * @return this is used to return the card_number of the current card
     */
    public String getNumber() {
        return card_number;
    }
    
    /**
     * this method is used to shuffle the card
     */
    public void shufCards(){
        Collections.shuffle(list);
    }
    
    /**
     * this method is used to display available cards to players
     * @return this is used to return the available cards
     */
    public String showCards(){
        String show_list = "";
        for(int i=0;i<list.size();i++){
            String a = list.get(i).getColor() + list.get(i).getNumber()+ " ";
            show_list = show_list + a;
        }
        return show_list;
    }
    
    /**
     * copy the list of available cards in a vector list
     * @return the vector list (copy of available cards)
     */
    public Vector get_copy_of_list(){
        Vector vec = new Vector();
        for(int i=0;i<list.size();i++){
            String a = list.get(i).getColor() + list.get(i).getNumber();
            vec.add(a);
        }
        return vec;
    }
    
    /**
     * used to display the copy list of the available cards, 20 cards each row
     * @return list of available cards
     */
    public String arrange_vec_copy(){
        String a = "";
        for(int i=0; i < list_copy.size(); i++){
            a = a + list_copy.get(i) + " ";
            if(i>0 && i%20==0){
                a = a + "\n";
            }
        }
        return a;
    }
    /**
     * This method is used to tell use which round are they playing
     * @return the round number
     */
    public int get_round_number(){
        round_number = round_number + 1;
        return round_number;
    }
    
    /**
     * This give_card_to_player method is designed to distribute cards to each player.
     */
    public void give_card_to_player(){
        
        //create four players
        
        Vector<String> player1_cards = new Vector<>();
        Vector<String> player2_cards = new Vector<>();
        Vector<String> player3_cards = new Vector<>();
        Vector<String> player4_cards = new Vector<>();
        
        
        //each player grabs 3 cards for each time
        //each card is seleted randomly from the list
        for(int i=0; i<3; i++){
            int num=random.nextInt(list_copy.size());
            player1_cards.add((String) list_copy.get(num));
            list_copy.remove(num);
            int num2=random.nextInt(list_copy.size());
            player2_cards.add((String) list_copy.get(num2));
            list_copy.remove(num2);
            int num3=random.nextInt(list_copy.size());
            player3_cards.add((String) list_copy.get(num3));
            list_copy.remove(num3);
            int num4=random.nextInt(list_copy.size());
            player4_cards.add((String) list_copy.get(num4));
            list_copy.remove(num4);
        }
        // go to classify the cards
        classification_of_cards(player1_cards);
        classification_of_cards(player2_cards);
        classification_of_cards(player3_cards);
        classification_of_cards(player4_cards);
        
        //copy each of the stored cards of each round for further processing
        copy_player1_cards = player1_cards;
        copy_player2_cards = player2_cards;
        copy_player3_cards = player3_cards;
        copy_player4_cards = player4_cards;
        
        //go to display the score each player got
        display_sum();     
    }
    /**
     * This method is used to get the player1 cards
     * @return the cards that player1 got
     */
    public Vector get_p1_cards(){
        return copy_player1_cards;
    }
    /**
     * This method is used to get the player2 cards
     * @return the cards that player2 got
     */
    public Vector get_p2_cards(){
        return copy_player2_cards;
    }
    /**
     * This method is used to get the player3 cards
     * @return the cards that player3 got
     */
    public Vector get_p3_cards(){
        return copy_player3_cards;
    }
    /**
     * This method is used to get the player4 cards
     * @return the cards that player4 got
     */
    public Vector get_p4_cards(){
        return copy_player4_cards;
    }
    /**
     * This method is used to classify different types of cards into separate vectors
     * @param u means the list of the available cards
     */
    public void classification_of_cards (Vector u){
        for(int j=0; j<u.size(); j++){
            String a = u.get(j).toString();
            if(a.startsWith("C")){
                c_card_list.add((String) u.get(j));
            }
            else if(a.startsWith("D")){
                d_card_list.add((String) u.get(j));
            }
            else if(a.startsWith("H")){
                h_card_list.add((String) u.get(j));
            }
            else if(a.startsWith("S")){
                s_card_list.add((String) u.get(j));
            }
        }
    }
    
    /**
     * This method is used to get the 'C' cards list
     * @return the cards which is C
     */
    public Vector display_c_cards(){
        return(c_card_list);
    }
    /**
     * This method is used to get the 'D' cards list
     * @return the cards which is D
     */
    public Vector display_d_cards(){
        return(d_card_list);
    }
    /**
     * This method is used to get the 'H' cards list
     * @return the cards which is H
     */
    public Vector display_h_cards(){
        return(h_card_list);
    }
    /**
     * This method is used to get the 'S' cards list
     * @return the cards which is S
     */
    public Vector display_s_cards(){
        return(s_card_list);
    }
    
    /**
     * This method is used display the number of wins each player get
     * @return each player's number of win.
     */
    public String display_wins_count(){
        return("P1 = " + player1_wins_count + "  P2 = " + player2_wins_count + "  P3 = " + player3_wins_count + "  P4 = " + player4_wins_count );
    }
    
    /**
     * This method is used to display the score of the player after each rounds
     */
   public void display_sum(){
       
       player1_score = calculate_sum(copy_player1_cards);
       player2_score = calculate_sum(copy_player2_cards);
       player3_score = calculate_sum(copy_player3_cards);
       player4_score = calculate_sum(copy_player4_cards);
            
       if(player1_score>player2_score && player1_score>player3_score && player1_score>player4_score){
           player1_info=  copy_player1_cards + "| Sum = " + player1_score + "| Winner";
           player1_wins_count++;
       }else{
           player1_info=  copy_player1_cards + "| Sum = " + player1_score;
       }
       
       if(player2_score>player1_score && player2_score>player3_score && player2_score>player4_score){
           player2_info=  copy_player2_cards + "| Sum = " + player2_score + "| Winner";
           player2_wins_count++;
       }else{
           player2_info=  copy_player2_cards + "| Sum = " + player2_score;
       }
       
       if(player3_score>player1_score && player3_score>player2_score && player3_score>player4_score){
           player3_info=  copy_player3_cards + "| Sum = " + player3_score + "| Winner";
           player3_wins_count++;
       }else{
           player3_info=  copy_player3_cards + "| Sum = " + player3_score;
       }
       
       if(player4_score>player1_score && player4_score>player2_score && player4_score>player3_score){
           player4_info=  copy_player4_cards + "| Sum = " + player4_score + "| Winner";
           player4_wins_count++;
       }else{
           player4_info=  copy_player4_cards + "| Sum = " + player4_score;
       }
       
       System.out.println(player1_info + "\n"+ player2_info + "\n" + player3_info +"\n" + player4_info );
   }
   /**
    * This method is used to generate the information of player1's details for each round
    * @return the player1 details of each round
    */
   public String p1_cards_info(){
       return player1_info;
   }
   /**
    * This method is used to generate the information of player2's details for each round
    * @return the player2 details of each round
    */
   public String p2_cards_info(){
       return player2_info;
   }
   /**
    * This method is used to generate the information of player3's details for each round
    * @return  the player3 details of each round
    */
   public String p3_cards_info(){
       return player3_info;
   }
   /**
    * This method is used to generate the information of player4's details for each round
    * @return the player4 details of each round
    */
   public String p4_cards_info(){
       return player4_info;
   }
   /**
    * This method is used to calculate the sum of the score for each round
    * @param v each player's score
    * @return the sum of each rounds a player get
    */
   public int calculate_sum(Vector v){
       int sum=0;
       int adder; // adder determined by the card_number
       for(int i=0; i<v.size(); i++){
           String a = v.get(i).toString();
           a = a.substring(1); //extract the first String
           if("A".equals(a)){
               adder = 1;
           }
           else if("2".equals(a)){
               adder = 2;
           }
           else if("3".equals(a)){
               adder = 3;
           }
           else if("4".equals(a)){
               adder = 4;
           }
           else if("5".equals(a)){
               adder = 5;
           }
           else if("6".equals(a)){
               adder = 6;
           }
           else if("7".equals(a)){
               adder = 7;
           }
           else if("8".equals(a)){
               adder = 8;
           }
           else if("9".equals(a)){
               adder = 9;
           }
           else{
               adder = 0;
           }
           sum = sum + adder;
       }
       return sum%10; // get rightmost digit
   }

   /**
    * This method is used to compare each player's score to identify the winner,
    * if two or above players share the same maximum score, then there should be no winner
    * @param p1 player 1 score
    * @param p2 player 2 score
    * @param p3 player 3 score
    * @param p4 player 4 score
    * @return  the winner
    */
   public static String isWinner(int p1, int p2, int p3, int p4){
       System.out.println();
       if(p1>p2 && p1>p3 && p1>p4){
           winner = "P1 wins this game! Congrats!";
       }else if(p2>p1 && p2>p3 && p2>p4){
           winner = "P2 wins this game! Congrats!";
       }else if(p3>p1 && p3>p2 && p3>p4){
           winner = ("P3 wins this game! Congrats!");
       }else if(p4>p1 && p4>p2 && p4>p3){
           winner = ("P4 wins this game! Congrats!");
       }else{
           winner = ("No one wins this game.");
       }
       return winner;
   }
}
