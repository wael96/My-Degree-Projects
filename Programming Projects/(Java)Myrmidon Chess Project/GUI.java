import Board.Board;
import Piece.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;

//This Class focus on the design of GUI with its functions

public class GUI extends JFrame{


    // First, we create menus
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem saveGame = new JMenuItem("Save Game");
    JMenuItem loadGame = new JMenuItem("Load Game");

    //The Board will be consists of 42 buttons
    JButton[][] jb = new JButton[6][7];


    //initialize the tile's name before you click a button.
    String startTile = null;
    String destinationTile = null;

    //We get a copy of board from the Board Class
    Board board = new Board();
    String[][] copyOfBoard = board.chessBoard;


    //initialize the tile's position
    String positionOfDestinationTile;
    String positionOfStartTile;

    //set red player to play at first
    boolean redPlayerTurn = true;
    boolean bluePlayerTurn = false;

    //initialize if a move is legal or not
    boolean state;
    boolean legalMoveState = false;

    //After a player click on the destination tile, it will take some information about start tile as well
    String copyStartTilePiece;
    int copyStartRow;
    int copyStartColumn;


    //initialize all the available move a player can play.
    List<int[]> availableMoveList = new ArrayList<int[]>();


    //initialize number of turns
    int counter=0;



    public GUI(){
        super("Myrmidon Chess");
        menuBar.add(menu);
        menu.add(saveGame);
        saveGame.addActionListener(new ActionListener() {
            @Override
            //We save player's turn & board information to a txt file.
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save Done");
                try {
                    PrintWriter pr = new PrintWriter("file.txt");
                    String turn = getPlayerTurn(redPlayerTurn,bluePlayerTurn);
                    pr.print(turn);
                    for(int i=0; i<6; i++){
                        for(int j=0; j<7; j++){
                            pr.print(copyOfBoard[i][j]);
                        }
                    }
                    pr.close();
                }catch(Exception a) {
                    a.printStackTrace();
                }
            }
        });
        menu.add(loadGame);
        //First, we read whose turn is it by extracting 1st character
        //Then we read next 3 characters each time, and load the strings to the board
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int begin_index=1;
                    int end_index = 4;
                    Scanner scanner = new Scanner( new File("file.txt") );
                    String text = scanner.useDelimiter("\\A").next();
                    if(text.startsWith("r")){
                        redPlayerTurn = true;
                        bluePlayerTurn = false;
                    }else if(text.startsWith("b")){
                        redPlayerTurn = false;
                        bluePlayerTurn = true;
                    }
                    for(int a=0; a<6; a++){
                        for(int b=0; b<7; b++){
                            copyOfBoard[a][b] = text.substring(begin_index,end_index);
                            begin_index += 3;
                            end_index += 3;
                        }
                    }
                    scanner.close();
                    assignImageAfterFlipBoard(jb,copyOfBoard);
                } catch (IOException i) {
                    System.out.println("Problems..");
                }
            }
        });
        setJMenuBar(menuBar);
        SetUpBoard();
        setSize(800,700);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //We create 42 Jbuttons across the board
    //Then we assign the images to each button according to the information of the board
    //Then we add actionListener to each button
    public void SetUpBoard() {
        JPanel jp = new JPanel(new GridLayout(6,7));
        for(int row=0; row<6; row++){
            for (int col=0; col<7; col++){
                jb[row][col] = new JButton();
                jp.add(jb[row][col]);
                assignImage(jb,row,col,copyOfBoard);
                ButtonStuff bs = new ButtonStuff(row,col,jb,copyOfBoard);
            }
        }
        add(jp);
    }

    //Take information from the board, and initialize image of piece on the button correctly
    public void assignImage(JButton[][] jb, int row, int col, String[][] copyOfBoard) {
        try {
            if(copyOfBoard[row][col].startsWith("bp1")
                    || copyOfBoard[row][col].startsWith("bp2")){
                Image img = ImageIO.read(getClass().getResource("Image/BluePlus.png"));
                Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                jb[row][col].setIcon(new ImageIcon(newimg));
            }
            if(copyOfBoard[row][col].startsWith("bt1")
                    || copyOfBoard[row][col].startsWith("bt2")){
                Image img = ImageIO.read(getClass().getResource("Image/BlueTriangle.png"));
                Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                jb[row][col].setIcon(new ImageIcon(newimg));
            }
            if(copyOfBoard[row][col].startsWith("bs")){
                Image img = ImageIO.read(getClass().getResource("Image/BlueSun.png"));
                Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                jb[row][col].setIcon(new ImageIcon(newimg));
            }
            if(copyOfBoard[row][col].startsWith("bc1")
                    || copyOfBoard[row][col].startsWith("bc2")){
                Image img = ImageIO.read(getClass().getResource("Image/BlueChevron.png"));
                Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                jb[row][col].setIcon(new ImageIcon(newimg));
            }
            if(copyOfBoard[row][col].startsWith("rp1")
                    || copyOfBoard[row][col].startsWith("rp2")){
                Image img = ImageIO.read(getClass().getResource("Image/RedPlus.png"));
                Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                jb[row][col].setIcon(new ImageIcon(newimg));
            }
            if(copyOfBoard[row][col].startsWith("rt1") || copyOfBoard[row][col].startsWith("rt2")){
                Image img = ImageIO.read(getClass().getResource("Image/RedTriangle.png"));
                Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                jb[row][col].setIcon(new ImageIcon(newimg));
            }
            if(copyOfBoard[row][col].startsWith("rs") ){
                Image img = ImageIO.read(getClass().getResource("Image/RedSun.png"));
                Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                jb[row][col].setIcon(new ImageIcon(newimg));
            }
            if(copyOfBoard[row][col].startsWith("rc1")
                    || copyOfBoard[row][col].startsWith("rc2")){
                Image img = ImageIO.read(getClass().getResource("Image/RedChevron.png"));
                Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                jb[row][col].setIcon(new ImageIcon(newimg));
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    //After flip the board, the image information need to be updated as well;
    public void assignImageAfterFlipBoard(JButton[][] jb, String[][] copyOfBoard) {
        try {
            for(int i=0; i<6; i++){
                for(int j=0; j<7; j++){
                    if(copyOfBoard[i][j].startsWith(" - ")){
                        jb[i][j].setIcon(null);
                    }
                    if(copyOfBoard[i][j].startsWith("bp1")
                            || copyOfBoard[i][j].startsWith("bp2")){
                        Image img = ImageIO.read(getClass().getResource("Image/BluePlus.png"));
                        Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                        jb[i][j].setIcon(new ImageIcon(newimg));
                    }
                    if(copyOfBoard[i][j].startsWith("bt1")
                            || copyOfBoard[i][j].startsWith("bt2")){
                        Image img = ImageIO.read(getClass().getResource("Image/BlueTriangle.png"));
                        Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                        jb[i][j].setIcon(new ImageIcon(newimg));
                    }
                    if(copyOfBoard[i][j].startsWith("bs")){
                        Image img = ImageIO.read(getClass().getResource("Image/BlueSun.png"));
                        Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                        jb[i][j].setIcon(new ImageIcon(newimg));
                    }
                    if(copyOfBoard[i][j].startsWith("bc1")
                            || copyOfBoard[i][j].startsWith("bc2")){
                        Image img = ImageIO.read(getClass().getResource("Image/BlueChevron.png"));
                        Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                        jb[i][j].setIcon(new ImageIcon(newimg));
                    }
                    if(copyOfBoard[i][j].startsWith("rp1")
                            || copyOfBoard[i][j].startsWith("rp2")){
                        Image img = ImageIO.read(getClass().getResource("Image/RedPlus.png"));
                        Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                        jb[i][j].setIcon(new ImageIcon(newimg));
                    }
                    if(copyOfBoard[i][j].startsWith("rt1")
                            || copyOfBoard[i][j].startsWith("rt2")){
                        Image img = ImageIO.read(getClass().getResource("Image/RedTriangle.png"));
                        Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                        jb[i][j].setIcon(new ImageIcon(newimg));
                    }
                    if(copyOfBoard[i][j].startsWith("rs") ){
                        Image img = ImageIO.read(getClass().getResource("Image/RedSun.png"));
                        Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                        jb[i][j].setIcon(new ImageIcon(newimg));
                    }
                    if(copyOfBoard[i][j].startsWith("rc1")
                            || copyOfBoard[i][j].startsWith("rc2")){
                        Image img = ImageIO.read(getClass().getResource("Image/RedChevron.png"));
                        Image newimg = img.getScaledInstance( 100, 100,Image.SCALE_SMOOTH ) ;
                        jb[i][j].setIcon(new ImageIcon(newimg));
                    }
                }
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }


    //This function is used to obtain whose turn is it
    public String getPlayerTurn(boolean redPlayerTurn, boolean bluePlayerTurn) {
        String str = "";
        if(redPlayerTurn == true){
            str = "r";
        }else if(bluePlayerTurn == true) {
            str = "b";
        }
        return str;
    }

    //This class will focus on the event of 42 buttons
    //This is the most creative, most effective, most intelligent class I've ever seen
    //The class will need the information of the row && column of the button you clicked and the information about the board
    public class ButtonStuff{
        public ButtonStuff(int row, int col, JButton[][] jb, String[][] copyOfBoard){
            jb[row][col].addActionListener(new ActionListener() {
                @Override
                //before a player clicks a button, both of the startTile and destinationTile is null;
                public void actionPerformed(ActionEvent e) {
                    getPlayerTurn(redPlayerTurn,bluePlayerTurn);
                    String value = copyOfBoard[row][col];
                    if(startTile==null
                            && (value.contains(getPlayerTurn(redPlayerTurn,bluePlayerTurn)))){
                        saveGame.setEnabled(false);
                        loadGame.setEnabled(false);
                        copyStartTilePiece = value;
                        copyStartRow = row;
                        copyStartColumn = col;
                        startTile = value;
                        positionOfStartTile = Integer.toString(row)+Integer.toString(col);
                        //get startTile Piece and handle its movement
                        try { getStartTilePiece(); }catch(Exception ex){};
                        //After player made a move, the board will be updated
                        copyOfBoard[row][col] = " - ";
                        destinationTile = null;
                    }else if(startTile!=null
                            && destinationTile == null){
                        //when a player clicked a startTile and before he click the desination tile, he reach here.
                        saveGame.setEnabled(true);
                        loadGame.setEnabled(true);
                        destinationTile = value;
                        positionOfDestinationTile = Integer.toString(row)+Integer.toString(col);
                        //check if the move made by player is legal or not
                        state = handleLegalMoves(row,col,startTile);

                        if(state==true) {
                            //if legal, execute following code
                            //move + 1
                            counter += 1;
                            //remove highlighted square color
                            restoreSquareColor();
                            copyOfBoard[row][col] = startTile;
                            removeStartTileIcon(jb);
                            assignImage(jb, row, col, copyOfBoard);
                            flipBoard();
                            //check if pieces should be transformed
                            transformPiece(counter);
                            //update image of pieces
                            assignImageAfterFlipBoard(jb,copyOfBoard);

                            // set playerTurn according to the move made by the player
                            if (redPlayerTurn == true) {
                                redPlayerTurn = false;
                                bluePlayerTurn = true;
                            } else {
                                redPlayerTurn = true;
                                bluePlayerTurn = false;
                            }

                            if (positionOfDestinationTile.equals(positionOfStartTile)) {
                                if (redPlayerTurn == true) {
                                    redPlayerTurn = false;
                                    bluePlayerTurn = true;
                                } else {
                                    redPlayerTurn = true;
                                    bluePlayerTurn = false;
                                }
                            }

                            //After a move made, whether it's legal or not, we refresh the status of the tiles anyway
                            startTile = null;
                            checkGameStatus(getPlayerTurn(redPlayerTurn,bluePlayerTurn),destinationTile);

                        }else{
                            //keep everything same as before if illegal move have been played.
                            restoreSquareColor();
                            copyOfBoard[copyStartRow][copyStartColumn] = copyStartTilePiece;
                            if(redPlayerTurn == true){
                                redPlayerTurn = true;
                                bluePlayerTurn = false;
                            }else{
                                redPlayerTurn = false;
                                bluePlayerTurn = true;
                            }
                            startTile = null;
                        }

                    }else {
                        startTile = null;
                        destinationTile = null;
                    }
                }


                //To carry out the implementation of the transform Pieces
                public void transformPiece(int counter) {
                    if(counter>3  && counter%6 == 0 )
                    for(int i=0; i<6; i++){
                        for(int j=0; j<7; j++){
                            if(copyOfBoard[i][j].equals("bp1")){
                                copyOfBoard[i][j] = "bt1";
                            }
                            else if(copyOfBoard[i][j].equals("bp2")){
                                copyOfBoard[i][j] = "bt2";
                            }
                            else if(copyOfBoard[i][j].equals("rp1")){
                                copyOfBoard[i][j] = "rt1";
                            }
                            else if(copyOfBoard[i][j].equals("rp2")){
                                copyOfBoard[i][j] = "rt2";
                            }
                            else if(copyOfBoard[i][j].equals("bt1")){
                                copyOfBoard[i][j] = "bc1";
                            }
                            else if(copyOfBoard[i][j].equals("bt2")){
                                copyOfBoard[i][j] = "bc2";
                            }
                            else if(copyOfBoard[i][j].equals("rt1")){
                                copyOfBoard[i][j] = "rc1";
                            }
                            else if(copyOfBoard[i][j].equals("rt2")){
                                copyOfBoard[i][j] = "rc2";
                            }
                            else if(copyOfBoard[i][j].equals("bc1")){
                                copyOfBoard[i][j] = "bp1";
                            }
                            else if(copyOfBoard[i][j].equals("bc2")){
                                copyOfBoard[i][j] = "bp2";
                            }
                            else if(copyOfBoard[i][j].equals("rc1")){
                                copyOfBoard[i][j] = "rp1";
                            }
                            else if(copyOfBoard[i][j].equals("rc2")){
                                copyOfBoard[i][j] = "rp2";
                            }
                        }
                    }
                }



                public void flipBoard() {
                    for(int a=0; a<3; a++){
                        for(int b=0; b<7; b++){
                            String temp = copyOfBoard[a][b];
                            copyOfBoard[a][b] = copyOfBoard[5-a][6-b];
                            copyOfBoard[5-a][6-b] = temp;
                        }
                    }
                }

                //Check if the game end or not
                public void checkGameStatus(String playerTurn,String destinationPiece) {
                    String gameEndMessage = "";
                    boolean isGameEnd = false;
                    
                    if(destinationPiece.startsWith("bs")){
                        isGameEnd = true;
                        gameEndMessage = "Red Win! Would you like to have a new game?(Click No to exit)";
                    }
                    if(destinationPiece.startsWith("rs")){
                        isGameEnd = true;
                        gameEndMessage = "Blue Win! Would you like to have a new game?(Click No to exit)";
                        
                    }

                    if(isGameEnd == true){
                        System.out.println(gameEndMessage);
                        System.out.println("Game has end!");
                        legalMoveState = true;

                        JFrame frame = new JFrame();
                        Object[] options = {"Yes", "No"};
                        int n = JOptionPane.showOptionDialog(frame,
                                gameEndMessage,
                                "Game End!",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]);
                        if (n == JOptionPane.YES_OPTION) {
                            setVisible(false);
                            new GUI();
                        } else if (n == JOptionPane.NO_OPTION) {
                            System.exit(0);
                        }
                    }
                }


                //return to ButtonStuff is a move legal or not
                public boolean handleLegalMoves(int row,int col, String startTile) {
                    if(startTile.startsWith("b")|| startTile.startsWith("r")){
                        List<int[]> availableMove = availableMoveList;
                        for(int i=0; i<availableMove.size();i++){
                            int x = availableMove.get(i)[0];
                            int y = availableMove.get(i)[1];
                            if((x == row) && (y == col)){
                                legalMoveState = true;
                                break;
                            }else {
                                legalMoveState = false;
                            }
                        }
                    }
                    return legalMoveState;
                }

                //refresh image after a move have played
                public void removeStartTileIcon(JButton[][] jb) {
                    for(int i=0; i<6; i++){
                        for(int j=0; j<7; j++){
                            if(copyOfBoard[i][j] == " - "){
                                jb[i][j].setIcon(null);
                            }
                        }
                    }
                }

                //get the piece of button you clicked, and store that's piece's movement
                //***This is the function that is part of our "Strategy Design Pattern"***//
                public void getStartTilePiece() {
                    if(startTile.startsWith("bp") || startTile.startsWith("rp") ){
                        Context context = new Context(new Plus());
                        List<int[]> ar = context.executePieceRule(row,col,getPlayerTurn(redPlayerTurn,bluePlayerTurn),copyOfBoard);
                        availableMoveList = ar;
                        highLightSquare(row,col,ar);
                    }
                    if(startTile.startsWith("bt") || startTile.startsWith("rt") ){
                        Context context = new Context(new Triangle());
                        List<int[]> ar = context.executePieceRule(row,col,getPlayerTurn(redPlayerTurn,bluePlayerTurn),copyOfBoard);
                        availableMoveList = ar;
                        highLightSquare(row,col,ar);
                    }
                    if(startTile.startsWith("bc") || startTile.startsWith("rc") ){
                        Context context = new Context(new Chevron());
                        List<int[]> ar = context.executePieceRule(row,col,getPlayerTurn(redPlayerTurn,bluePlayerTurn),copyOfBoard);
                        availableMoveList = ar;
                        highLightSquare(row,col,ar);
                    }
                    if(startTile.startsWith("bs") || startTile.startsWith("rs") ){
                        Context context = new Context(new Sun());
                        List<int[]> ar = context.executePieceRule(row,col,getPlayerTurn(redPlayerTurn,bluePlayerTurn),copyOfBoard);
                        availableMoveList = ar;
                        highLightSquare(row,col,ar);
                    }
                }

                //Highlight the available move on the board
                public void highLightSquare(int row, int col, List<int[]> ar) {
                    for(int a=0; a<ar.size();a++){
                        jb[ar.get(a)[0]][ar.get(a)[1]].setBackground(Color.blue);
                    }
                }
            });
        }

        //unhightlight the available move on the board
        public void restoreSquareColor() {
            for(int i=0; i<6; i++){
                for (int j=0; j<7; j++){
                    jb[i][j].setBackground(null);
                }
            }
        }
    }
}