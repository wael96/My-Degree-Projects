/*
 * This class focus on the movement of Plus
 * */

package Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Plus implements Piece {
    @Override
    public List<int[]> PieceRule(int i, int j, String playerTurn, String[][] copyOfBoard) {
        //make a list of potential available squares of plus and modify the list by its current position and its surrounding piece position
        List<int[]> rowList = new ArrayList<int[]>();
        int[][] availableCoordinate ={{i+2,j},{i,j+2},{i+1,j},{i,j+1},{i-2,j},{i,j-2},{i-1,j},{i,j-1}};

        for(int a=0; a<availableCoordinate.length; a++){
            if(playerTurn=="b") {
                int x = availableCoordinate[a][0];
                int y = availableCoordinate[a][1];
                try {
                    if(copyOfBoard[Math.abs(x)][Math.abs(y)].startsWith("b")){
                        continue;
                    }
                }catch (Exception e){}
                if (availableCoordinate[a][0] < 0 || availableCoordinate[a][0] > 5) {
                    continue;
                } else if (availableCoordinate[a][1] < 0 || availableCoordinate[a][1] > 6) {
                    continue;
                }else {
                    rowList.add(availableCoordinate[a]);
                }
            }
            if(playerTurn=="r") {
                int x = availableCoordinate[a][0];
                int y = availableCoordinate[a][1];
                try {
                    if(copyOfBoard[Math.abs(x)][Math.abs(y)].startsWith("r")){
                        continue;
                    }
                }catch (Exception e){}
                if (availableCoordinate[a][0] < 0 || availableCoordinate[a][0] > 5) {
                    continue;
                } else if (availableCoordinate[a][1] < 0 || availableCoordinate[a][1] > 6) {
                    continue;
                } else {
                    rowList.add(availableCoordinate[a]);
                }
            }
        }
        for(int a=0; a<rowList.size(); a++ ){
            int x = rowList.get(a)[0];
            int y = rowList.get(a)[1];
            if((x+2==i) && (copyOfBoard[x+1][j].startsWith("b") || copyOfBoard[x+1][j].startsWith("r"))){
                rowList.remove(a);
            }
            if((x-2==i) && (copyOfBoard[x-1][j].startsWith("b") || copyOfBoard[x-1][j].startsWith("r"))){
                rowList.remove(a);
            }
            if((y+2==j) && (copyOfBoard[i][y+1].startsWith("b") || copyOfBoard[i][y+1].startsWith("r"))){
                rowList.remove(a);
            }
            if((y-2==j) && (copyOfBoard[i][y-1].startsWith("b") || copyOfBoard[i][y-1].startsWith("r"))){
                rowList.remove(a);
            }
        }
        return rowList;
    }
}