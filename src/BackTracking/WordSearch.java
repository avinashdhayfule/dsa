package src.BackTracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int row = 0 ; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                boolean isExist = backTrack(board, word, visited, row, col, 0);

                if(isExist) return true;
            }
        }

        return false;
    }

    public boolean backTrack(char[][] board, String word, boolean[][] visited, int row, int col, int index) {

        if(index == word.length()) return true;

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index) || visited[row][col]) return false;
        visited[row][col] = true;

        if(backTrack(board, word, visited, row + 1, col, index + 1 ) ||
                backTrack(board, word, visited, row - 1, col, index + 1 ) ||
                backTrack(board, word, visited, row, col - 1, index + 1 ) ||
                backTrack(board, word, visited, row, col + 1, index + 1 )
        ) return true;

        visited[row][col] = false;

        return false;
    }
}
