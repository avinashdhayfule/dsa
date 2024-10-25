package src.TwoPointers;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int left = 1;
        for(int right = 1; right < nums.length; right++){
            while(nums[right] != nums[left - 1]){
                nums[left++] = nums[right];
            }
        }
        return left;
    }
}
