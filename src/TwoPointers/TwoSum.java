package src.TwoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2,2,2,7,7,7,11,15}, 9));
    }
    public static List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[left]) ;
                pair.add(nums[right]);
                result.add(pair);
                left++; right--;
                while(left > 0 && nums[left] == nums[left-1]){
                    left++;
                }
                while(right < nums.length - 1 && nums[right] == nums[right + 1]){
                    right--;
                }
            }else if( sum < target){
                left++;
            }else{
                right--;
            }

        }
        return result;
    }
}
