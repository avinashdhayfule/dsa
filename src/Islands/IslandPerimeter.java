package src.Islands;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int row = 0 ; row< grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                perimeter = findPerimeter(grid, row, col, perimeter);
            }
        }

        return perimeter;
    }

    public int findPerimeter(int[][] grid, int row, int col, int perimeter){
        if (row < 0 || row >= grid.length ||  col < 0 || col >= grid[0].length || grid[row][col] == 0) return perimeter;

        if (grid[row][col] == 1){
            if (row - 1 < 0 || grid[row - 1 ][col] == 0) perimeter ++;

            if (row + 1 > grid.length - 1 || grid[row + 1 ][col] == 0) perimeter ++;

            if (col - 1 < 0 || grid[row ][col - 1] == 0) perimeter ++;

            if (col + 1 > grid[0].length - 1 || grid[row ][col + 1] == 0) perimeter ++;
        }

        return perimeter;
    }
}
