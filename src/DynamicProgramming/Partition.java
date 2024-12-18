package src.DynamicProgramming;

public class Partition {
    public boolean canPartition(int[] nums) {
        int n =  nums.length;

        int sum = 0;
        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 != 0)
            return false;

        sum =  sum/2;

        boolean dp[][] = new boolean [nums.length] [sum + 1];

        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= sum; i++){
            if(nums[0] == i ){
                dp[0][i] = true;
            }else{
                dp[0][i] = false;
            }
        }


        for(int i = 1 ; i < nums.length; i++){
            boolean flag1 = false;
            boolean flag2 = false;
            for(int j = 1; j <= sum; j++){
                int num = nums[i];

                if(dp[i - 1][j]){
                    dp[i][j] = dp[i - 1][j];
                }else  if(j >= num){
                    dp[i][j] = dp[i - 1][j - num];
                }
            }
        }

        return dp[n - 1][sum];
    }
}
