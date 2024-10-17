package DynamicProgramming;

public class SubsetCountWithSum {
    public static void main(String[] args) {
        System.out.println(countOfSubsets(new int[]{1, 1, 2, 3}, 4));
        System.out.println(countOfSubsets(new int[]{1, 2, 7, 1, 5}, 9));
    }
    public static int countOfSubsets(int[] nums, int target){

        int[][] dp = new int[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= target; j++) {
            dp[0][j] = (j == nums[0]) ? 1 : 0;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >= nums[i]){
                    dp[i][j] += dp[i-1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][target];

    }
}
