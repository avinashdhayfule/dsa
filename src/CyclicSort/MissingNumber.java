package src.CyclicSort;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int i = 0;

        while(i < nums.length){
            int j = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else{
                i++;
            }
        }

        for(int k = 0;k < nums.length; k++){
            if( k != nums[k]){
                return k;
            }
        }
        return nums.length;
    }
}
