package src.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            int target = -nums[i];

            if(i > 0 && nums[i] == nums[i-1])
                continue;

            result = searchPair(nums, target, i+1, result);
        }

        return result;

    }

    private List<List<Integer>> searchPair(int[] nums, int target, int left ,       List<List<Integer>> triplets){

        int right = nums.length - 1;

        while(left < right){
            int sum = nums[right] + nums[left];

            if(sum == target){
                triplets.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left-1]){
                    left++;
                }
                while(right > left && nums[right] == nums[right+1]){
                    right--;
                }
            }else if( sum > target){
                right--;
            }else{
                left++;
            }

        }
        return triplets;
    }
}
