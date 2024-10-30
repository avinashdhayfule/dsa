package src.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        int windowStart = 0;
        long windowSum = 0;
        long maxSum = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){

            windowSum = windowSum + Long.parseLong(String.valueOf(nums[windowEnd]));
            if(windowEnd >= k - 1) {
                System.out.println(nums.length);
                if(!map.containsKey(nums[windowEnd]) && map.size() == k - 1){
                    maxSum = Math.max(windowSum, maxSum);
                }

                windowSum = windowSum - nums[windowStart];
                map.put(nums[windowEnd], windowEnd);
                if(map.getOrDefault(nums[windowStart], -1) <= windowStart)
                    map.remove(nums[windowStart]);
                windowStart++;
            }else{
                map.put(nums[windowEnd], windowEnd);
            }

        }
        return maxSum;
    }
}
