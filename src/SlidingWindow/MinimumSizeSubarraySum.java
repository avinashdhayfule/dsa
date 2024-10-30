package src.SlidingWindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int windowSum = 0;
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;

        for(int windowEnd = 0; windowEnd< nums.length; windowEnd++){
            windowSum = windowSum + nums[windowEnd];

            while(windowSum >= target){
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum = windowSum - nums[windowStart];
                windowStart++;
            }
        }
        if(minLength == Integer.MAX_VALUE)
            return 0;
        return minLength;
    }
}
