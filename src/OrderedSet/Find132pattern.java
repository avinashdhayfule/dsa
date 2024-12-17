package src.OrderedSet;

import java.util.TreeSet;

public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i= 1; i< nums.length; i++){
            min[i] = Math.min(min[i-1], nums[i]);
        }
        for(int i = nums.length - 1; i > 0; i--){
            Integer rightLowerBound = set.lower(nums[i]);

            if(rightLowerBound != null && min[i - 1] < nums[i] && min[i-1] < rightLowerBound){
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }
}
