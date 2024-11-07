package src.HashMap;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max =  Integer.MIN_VALUE;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : nums){
            if(map.get(num) == 1) max = Math.max(max, num);
        }

        if( max == Integer.MIN_VALUE) return -1;
        return max;
    }
}
