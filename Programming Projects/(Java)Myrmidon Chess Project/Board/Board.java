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
            { "bs1", "bc1", "bh", "bc2 ", "bs1"},
            { " - ", "ba1", "ba2", "ba3", " - "},
            { " - ", " - ", " - ", " - ", " - "},
            { " - ", " - ", " - ", " - ", " - "},
			{ " - ", " - ", " - ", " - ", " - "},
			{ " - ", " - ", " - ", " - ", " - "},
			{ " - ", "ra1", "ra2", "ra3", " - "},
            { "rs1", "rc1", "rh", "rc2 ", "rs1"}
            
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