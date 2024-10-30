package src.SlidingWindow;

public class MaxConsecutiveOnes {

    public int longestOnes(int[] nums, int k) {
        int windowStart = 0;
        int maxOnes = 0;
        int maxLen = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){

            if(nums[windowEnd] == 1){
                maxOnes++;

            }

            if(windowEnd - windowStart + 1 - maxOnes > k){

                if(nums[windowStart] == 1)
                    maxOnes--;

                windowStart++;
            }

            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);

        }

        return maxLen;

    }
}
