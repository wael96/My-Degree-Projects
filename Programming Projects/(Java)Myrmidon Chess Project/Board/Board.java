package Board;

public class Board {
    public int row = 6;
    public int col = 7;
    public String[][] chessBoard;

    public Board(){
        setUpBoard(row,col);
        getBoard(chessBoard);
    }

    public String[][] setUpBoard(int row, int col) {
        chessBoard = new String[][]{
            { "bp1", "bt1", "bc1", "bs ", "bc2", "bt2", "bp2"},
            { " - ", " - ", " - ", " - ", " - ", " - ", " - "},
            { " - ", " - ", " - ", " - ", " - ", " - ", " - "},
            { " - ", " - ", " - ", " - ", " - ", " - ", " - "},
            { " - ", " - ", " - ", " - ", " - ", " - ", " - "},
            {  "rp1", "rt1", "rc1", "rs ", "rc2", "rt2", "rp2"}
        };
        return chessBoard;
    }

    public String[][]  getBoard(String[][] chessBoard) {
        String[][] boardToString = new String[row][col];
        for(int i=0; i<row; i++ ){
            for(int j=0; j<col; j++){
                boardToString[i][j] = chessBoard[i][j].toString();
                //System.out.print(chessBoard[i][j]);
            }
            //System.out.println();
        }
        return boardToString;
    }
}