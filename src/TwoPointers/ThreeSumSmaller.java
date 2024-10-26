package src.TwoPointers;

import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int first = nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = first + nums[left] + nums[right];
                if(sum < target){
                    count += right - left;
                    left++;
                }else{
                    right--;
                }
            }
        }

        return count;
    }
}
