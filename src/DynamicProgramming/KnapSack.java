package src.DynamicProgramming;

public class KnapSack {
        static int knapSack(int W, int wt[], int val[]) {
            int[][] dp = new int[wt.length][W + 1];

            for(int i = 0; i< wt.length; i++){
                dp[i][0] = 0;
            }

            for(int i = 0; i <= W; i++){
                if(wt[0] <= i){
                    dp[0][i] = val[0];
                }
            }

            //i for weight j for capcity
            for(int i = 1; i < wt.length; i++){
                for(int j = 1; j <= W; j++){
                    int profit1 = 0;
                    int profit2 = 0;

                    if(wt[i] <= j){
                        profit1 = val[i] + dp[i - 1][j - wt[i]];
                    }

                    profit2 = dp[i - 1][j];

                    dp[i][j] = Math.max(profit1, profit2);

                }
            }

            return dp[wt.length - 1][W];
        }
}
