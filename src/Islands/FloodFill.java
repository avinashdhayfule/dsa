package src.Islands;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int oriColor = image[sr][sc];
        dfsGrid(image, sr, sc, color, oriColor);
        return image;
    }

    public void dfsGrid(int[][] image, int sr, int sc, int color, int oriColor) {

        if((sr >= 0 && sr < image.length) && (sc >= 0 && sc < image[0].length) && image[sr][sc] == oriColor){
            image[sr][sc] = color;

            dfsGrid(image, sr - 1, sc, color, oriColor);
            dfsGrid(image, sr + 1, sc, color, oriColor);
            dfsGrid(image, sr, sc - 1, color, oriColor);
            dfsGrid(image, sr, sc + 1, color, oriColor);
        }


    }
}
