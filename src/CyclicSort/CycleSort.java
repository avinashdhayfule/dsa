package src.CyclicSort;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int [] nums = {2, 6, 4, 3, 1, 5};
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

        System.out.println("After: "+Arrays.toString(nums));
    }
}
