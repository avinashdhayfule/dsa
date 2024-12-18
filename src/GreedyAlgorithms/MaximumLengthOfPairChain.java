package src.GreedyAlgorithms;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[0] - b [0]);

        int count = 1;
        int prev = pairs[0][1];
        for(int i = 1; i < pairs.length; i++){
            int[] pair = pairs[i];
            if(prev < pair[0]){
                count++;
                prev = pair[1];
            }else{
                prev = Math.min(prev, pair[1]);
            }
        }

        return count;
    }
}
