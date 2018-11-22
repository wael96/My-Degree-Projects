/*
* This class is part of our design pattern(Strategy Design Pattern)
* and this class act as a controller between GUI class and Piece class,
* GUI will ask this class to use the information of Pieces */

package Piece;

import java.util.List;

public class Context {
    private Piece piece;

    public Context(Piece piece){
        this.piece = piece;
    }

    public List<int[]> executePieceRule(int i, int j, String playerTurn, String[][] copyOfBoard){
        return piece.PieceRule(i,j,playerTurn,copyOfBoard);
    }
}