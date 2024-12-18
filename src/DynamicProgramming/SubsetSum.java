package src.DynamicProgramming;

public class SubsetSum {
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean[][] dp = new boolean[arr.length][sum + 1];

        for(int i = 0 ; i < arr.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1 ; i <= sum; i++){
            dp[0][i] = (arr[0] == i);
        }

        for(int i = 1 ; i < arr.length; i++){
            for(int j = 1 ; j <= sum; j++){
                if(dp[i-1][j]){
                    dp[i][j] = true;
                }else if(j >= arr[i]){
                    dp[i][j] = dp[i-1][j - arr[i]];
                }
            }
        }

        return dp[arr.length - 1][sum];
    }
}
