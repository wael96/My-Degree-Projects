package Piece;

/*
 * This class focus on the movement of Sun
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sun implements Piece {
    @Override
    public List<int[]> PieceRule(int i, int j, String playerTurn, String[][] copyOfBoard) {
        //make a list of potential available squares of Sun and modify the list by its current position
        List<int[]> rowList = new ArrayList<int[]>();
        int[][] availableCoordinate ={{i-1,j-1},{i-1,j},{i-1,j+1},{i,j-1},{i,j+1},{i+1,j-1},{i+1,j},{i+1,j+1}};

        for(int a=0; a<availableCoordinate.length; a++) {
            if (playerTurn == "b") {
                int x = availableCoordinate[a][0];
                int y = availableCoordinate[a][1];
                try {
                    if (copyOfBoard[Math.abs(x)][Math.abs(y)].startsWith("b")) {
                        continue;
                    }
                } catch (Exception e) {
                }
                if (availableCoordinate[a][0] < 0 || availableCoordinate[a][0] > 5) {
                    continue;
                } else if (availableCoordinate[a][1] < 0 || availableCoordinate[a][1] > 6) {
                    continue;
                } else {
                    rowList.add(availableCoordinate[a]);
                }
            }
            if (playerTurn == "r") {
                int x = availableCoordinate[a][0];
                int y = availableCoordinate[a][1];
                try {
                    if (copyOfBoard[Math.abs(x)][Math.abs(y)].startsWith("r")) {
                        continue;
                    }
                } catch (Exception e) {
                }
                if (availableCoordinate[a][0] < 0 || availableCoordinate[a][0] > 5) {
                    continue;
                } else if (availableCoordinate[a][1] < 0 || availableCoordinate[a][1] > 6) {
                    continue;
                } else {
                    rowList.add(availableCoordinate[a]);
                }
            }
        }
        for(int k=0; k<rowList.size();k++){
            System.out.print(Arrays.toString(rowList.get(k)) + " ");
        }
        return rowList;
    }
}