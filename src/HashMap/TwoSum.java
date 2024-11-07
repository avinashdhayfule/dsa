package src.HashMap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int start = 0;
        int end = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while(start < end){
            Integer diff = target - nums[start];
            if(map.containsKey(diff)){
                result[0] = map.get(diff);
                result[1] = start;
                break;
            }else{
                map.put(nums[start],start);
                start++;
            }
        }

        return result;
    }
}
