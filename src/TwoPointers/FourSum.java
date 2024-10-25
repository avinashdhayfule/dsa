package src.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadraplet = new ArrayList<>();

        for(int i = 0 ; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j< nums.length -2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                List<List<Integer>> pairs = searchPairs(nums, target, i, j, j+1, quadraplet);

            }

        }

        return quadraplet;
    }

    private List<List<Integer>> searchPairs(int[] nums, int target, int first, int second, int left, List<List<Integer>> quadraplet){
        int right = nums.length -1;
        while(left < right){
            long sum = (long)nums[first] + (long)nums[second] + (long)nums[left] + (long)nums[right];
            long diff = target - sum;
            if(diff == 0){

                quadraplet.add(Arrays.asList(nums[first], nums[second] , nums[left], nums[right]));

                left++;
                right--;

                while(left < right && nums[left] == nums[left - 1]) left++;
                while(left < right && nums[right] == nums[right + 1]) right--;
            }else if(diff > 0){
                left++;
            }else{
                right--;
            }
        }
        return quadraplet;
    }
}
