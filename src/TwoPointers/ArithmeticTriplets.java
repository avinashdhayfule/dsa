package src.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){

            int target = nums[i];

            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }

            searchPair(nums, target, diff, i + 1, triplets);

        }

        return triplets.size();
    }

    public void searchPair(int[] nums, int first, int diff, int left, List<List<Integer>>triplets){

        int right = nums.length - 1;

        while(left < right){
            if(nums[left] - first == diff){
                break;
            }else{
                left++;
            }

        }

        while(right > left){
            if(nums[right] - nums[left] == diff){
                List<Integer> triplet = new ArrayList<>();
                triplet.add(first);
                triplet.add(nums[left]);
                triplet.add(nums[right]);
                triplets.add(triplet);
                break;
            }else{
                right--;
            }
        }
    }
}
