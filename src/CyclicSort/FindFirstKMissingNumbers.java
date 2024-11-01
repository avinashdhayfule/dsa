package src.CyclicSort;

import java.util.*;

public class FindFirstKMissingNumbers {
    public static void main(String[] args) {
        int[] nums = {3, -1, 4, 5, 5};
        int k = 3;
        int i = 0;

        while(i < nums.length){
            int j = nums[i] - 1;

            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else{
                i++;
            }
        }

        List<Integer> missingNum = new ArrayList<>();
        Set<Integer> extra = new HashSet<>();
        for (int j = 0; j < nums.length && missingNum.size() < k; j++) {

            if(nums[j] != j+1 && !extra.contains(j + 1)){
                missingNum.add(j + 1);
            }
            extra.add(nums[j]);
        }

        if(k - missingNum.size() != 0){
            for (int j = 1; missingNum.size() < k; j++) {
                int candidateNumber = j + nums.length;
                if(!extra.contains(candidateNumber)){
                    missingNum.add(candidateNumber);
                }
            }
        }

        System.out.println(Arrays.toString(missingNum.toArray()));;
    }
}
