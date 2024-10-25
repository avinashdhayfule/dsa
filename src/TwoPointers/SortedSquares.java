package src.TwoPointers;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int[] sqrArr = new int[nums.length];
        int highestIndex = right;
        while(left <= right){
            int sqrtright = nums[right] * nums[right];
            int sqrtleft = nums[left] * nums[left];
            if(sqrtleft > sqrtright){
                sqrArr[highestIndex--] = sqrtleft;
                left++;

            }else{
                sqrArr[highestIndex--] = sqrtright;
                right--;

            }

        }

        return sqrArr;
    }
}
