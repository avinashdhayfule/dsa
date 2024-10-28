package src.TwoPointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindKDistantIndices {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIndex = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i++){
            if(key == nums[i]) keyIndex.add(i);
        }

        Set<Integer> result = new TreeSet<>();

        for(int index: keyIndex){
            int start = Math.max(index - k, 0);
            int end = Math.min(index + k, nums.length - 1);

            for(int i = start; i <= end; i++){
                result.add(i);
            }
        }

        return new ArrayList<>(result);


    }
}
