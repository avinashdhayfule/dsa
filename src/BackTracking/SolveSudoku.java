package src.BackTracking;

public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        solveBoard(board, 0 , 0);
    }

    public boolean solveBoard(char[][] board, int row, int col){

        if(row == board.length ) return true;

        if(col == board[0].length) return solveBoard(board, row + 1, 0);
        if(board[row][col] != '.') return solveBoard(board, row , col + 1);

        for(char ch = '1'; ch <= '9'; ch++){

            if(isValid(board, row, col, ch)){
                board[row][col] = ch;

                if(solveBoard(board, row , col + 1))
                    return true;

                board[row][col] = '.';
            }
        }

        return false;

    }

    public boolean isValid(char[][] board, int row, int col, char ch){

        for(int i = 0; i < board.length; i++ ){

            if(board[i][col] == ch) return false;

            if(board[row][i] == ch) return false;

            int subgridRow = 3 * (row/3) + i/3;
            int subgridCol = 3 * (col/3) + i%3;

            if(board[subgridRow][subgridCol] == ch)
                return false;

        }
        return true;
    }
}
