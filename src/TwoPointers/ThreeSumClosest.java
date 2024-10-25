package src.TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int closeness = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i< nums.length - 2; i++){
            int num = nums[i];
            int right = nums.length - 1;
            int left = i + 1;
            while(left < right){
                int sum = num + nums[left] + nums[right];
                if(target == sum) return sum;

                int diff = target - sum;

                if(Math.abs(diff) < Math.abs(closeness ) ||
                        (Math.abs(diff) == Math.abs (closeness) && diff > closeness))
                    closeness = diff;

                if( diff > 0){
                    left++;
                }else{
                    right--;
                }

            }

        }

        return target - closeness;
    }
}
