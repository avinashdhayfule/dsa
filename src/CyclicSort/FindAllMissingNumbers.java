package src.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> misingNumbers = new ArrayList();
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

        for(int k = 0 ; k < nums.length; k++){
            if(k+1 != nums[k])
                misingNumbers.add(k+1);
        }

        return misingNumbers;
    }
}
