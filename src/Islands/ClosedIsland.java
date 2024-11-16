package src.Islands;

public class ClosedIsland {
    public int closedIsland(int[][] grid) {
        int islands = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 0 && dfsGrid(grid, row, col)){
                    islands++;
                }
            }
        }
        return islands;
    }

    private boolean dfsGrid(int[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length )        return false ;

        if((row==0 || col==0 || row==grid.length-1 || col==grid[0].length-1) && grid[row][col]==0)
            return false;

        if(grid[row][col] == 1) return true;

        grid[row][col] = 1;

        return dfsGrid(grid, row - 1, col) &&
                dfsGrid(grid, row + 1, col) &&
                dfsGrid(grid, row, col - 1) &&
                dfsGrid(grid, row, col + 1);
    }
}
