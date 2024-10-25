package src.TwoPointers;

public class DuplicateZeros {
    public void duplicateZeros(int[] nums) {
        for(int left = 0 ; left < nums.length;  left++){
            if(nums[left] == 0){
                for(int right = nums.length - 1 ; right > left ; right--){
                    nums[right] = nums[right -1];
                }
                left++;
            }
        }
    }
}
