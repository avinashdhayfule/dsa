package src.Islands;

public class MaxAreaOfIsland {
    int max = Integer.MIN_VALUE;
    public int maxAreaOfIsland(int[][] grid) {

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    max = Math.max(max, dfsGrid(grid, row, col));
                }
            }
        }

        if(Integer.MIN_VALUE == max) max = 0;
        return max;
    }

    private int dfsGrid(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || col >= grid[0].length || row >= grid.length || grid[row][col] == 0 ){
            return 0;
        }
        else {
            grid[row][col] = 0;
            int nextRow = dfsGrid(grid, row + 1, col);
            int prevRow = dfsGrid(grid, row - 1, col);
            int nextCol = dfsGrid(grid, row, col + 1);
            int prevCol = dfsGrid(grid, row, col - 1);

            return 1 + nextRow + prevRow + nextCol + prevCol;
        }


    }
}
