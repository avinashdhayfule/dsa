package src.TwoPointers;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int left = 0;
        int right = 0;
        int count = 0;
        int product = 1;
        while(left < nums.length){
            while( right < nums.length && product * nums[right] < k){
                product = product * nums[right++];
            }
            count += (right - left);
            left++;
            right = left;
            product = 1;
        }
        return count;
    }
}
