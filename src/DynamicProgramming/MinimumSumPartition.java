package src.DynamicProgramming;

public class MinimumSumPartition {
    public int minDifference(int arr[], int n)
    {
        // Your code goes here
        int sum = 0;

        for(int num : arr){
            sum += num;
        }


        boolean[][] dp = new boolean[arr.length][sum/2 + 1];

        for(int i = 0; i < arr.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1 ; i <= sum/2; i++){
            dp[0][i] = (arr[0] == i);
        }

        for(int i = 1; i < arr.length; i++){
            for(int j = 1 ; j <= sum/2; j++){

                if(dp[i-1][j]){
                    dp[i][j] = true;
                }else if(j >= arr[i]){
                    dp[i][j] =  dp[i -1][j - arr[i]];
                }
            }
        }

        int sum1 = 0;

        for(int i = sum/2; i >= 0; i--){
            if(dp[arr.length - 1][i]){
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;

        return Math.abs(sum1 - sum2);
    }
}
