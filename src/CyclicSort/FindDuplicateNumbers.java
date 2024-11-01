package src.CyclicSort;

public class FindDuplicateNumbers {

    public int findDuplicate(int[] nums) {

        int i = 0;

        while(i < nums.length){
            int j = nums[i] - 1;
            if(nums[i] != nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else{
                i++;
            }
        }

        for(int k = 0;k < nums.length; k++){
            if( k + 1 != nums[k]){
                return  nums[k];
            }
        }
        return nums[nums.length - 1];

    }
}
