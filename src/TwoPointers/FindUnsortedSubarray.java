package src.TwoPointers;

public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right && nums[left] <= nums[left + 1]){
            left++;
        }

        if(left == nums.length -1) return 0;


        while(right > 0 && nums[right] >= nums [right - 1]){
            right--;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = left ; i < right + 1 ; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        while(left > 0 && nums[left - 1] > min) left--;
        while(right < nums.length - 1 && nums[right + 1] < max) right++;

        return right - left + 1;
    }

}
