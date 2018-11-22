/*
* This class we used a design pattern "Strategy Design Pattern"*/

package Piece;

import Board.Board;
import java.util.ArrayList;
import java.util.List;


//create an interface so that different pieces could extends this class
public interface Piece{
    public List<int[]> PieceRule(int i, int j, String playerTurn, String[][] copyOfBoard);
}
