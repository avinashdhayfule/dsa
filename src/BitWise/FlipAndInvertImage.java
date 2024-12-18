package src.BitWise;

public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int cols = image[0].length;

        for(int[] row : image){
            for(int i = 0 ; i < (cols + 1)/2; i++){
                int temp = row[i] ^ 1;
                row[i] = row[cols - 1 - i] ^ 1;
                row[cols - 1 - i] = temp;
            }
        }

        return image;
    }
}
