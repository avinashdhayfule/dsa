package src.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumbers {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList();
        int i = 0;
        while(i< nums.length){
            int j = nums[i] - 1;

            if(nums[i] != nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else{
                i++;
            }
        }

        for(int k = 0; k < nums.length; k++){
            if(k + 1 != nums[k] && nums[k] == nums[nums[k] - 1]){
                duplicates.add(nums[k]);
            }
        }

        return duplicates;
    }
}
