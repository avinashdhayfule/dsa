package src.Islands;

public class DetectCycle {
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited  = new boolean[grid.length][grid[0].length];
        for(int row = 0 ; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(!visited[row][col] && hasCycle(grid, visited, row, col, 0, grid[row][col])){
                    return true;
                }
            }
        }
        return false;
    }

    // @param direction: direction of move. dummy:0, down:1, up:2, left:3,right:4 for each.
    public boolean hasCycle(char[][] grid, boolean[][] visited, int row , int col, int direction, char prevChar){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != prevChar ) return false;

        if(visited[row][col]) return true;

        visited[row][col] = true;

        return ((direction != 2 &&  hasCycle(grid, visited, row - 1, col, 1, prevChar)) ||
                (direction != 1 &&  hasCycle(grid, visited, row + 1, col, 2, prevChar)) ||
                (direction != 4 &&  hasCycle(grid, visited, row, col - 1, 3, prevChar)) ||
                (direction != 3 &&  hasCycle(grid, visited, row, col + 1, 4, prevChar)));
    }
}
