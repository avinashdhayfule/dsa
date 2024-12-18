package src.BackTracking;

import java.util.Arrays;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return backTrack(nums, target, dp);
    }
    public int backTrack(int[] candidates, int target, int[] dp){

        if(dp[target] != -1) return dp[target];
        int result = 0;
        for(int i = 0; i < candidates.length; i++){
            if(target < candidates[i])
                continue;
            result += backTrack(candidates, target - candidates[i], dp);
        }

        dp[target] = result;


        return  dp[target];
    }
}
