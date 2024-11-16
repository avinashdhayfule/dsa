package src.Islands;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        int islands = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    dfsGrid(grid, row, col);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfsGrid(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || col >= grid[0].length || row >= grid.length || grid[row][col] != '1' ) return;

        grid[row][col] = '0';

        dfsGrid(grid, row + 1, col);
        dfsGrid(grid, row - 1, col);
        dfsGrid(grid, row, col + 1);
        dfsGrid(grid, row, col - 1);
    }
}
