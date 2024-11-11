package src.BinarySearch;

public class MaxInBitonicArray {
    public static void main(String[] args) {
        System.out.println(findMaxInBitonicArray(new int[]{1, 3, 8, 12, 4, 2}));
        System.out.println(findMaxInBitonicArray(new int[]{3, 8, 3, 1}));
        System.out.println(findMaxInBitonicArray(new int[]{1, 2, 3, 4}));
        System.out.println(findMaxInBitonicArray(new int[]{30, 30 ,10}));
    }
    public static int findMaxInBitonicArray(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = start + (end - start)/2;

            if(nums[mid] > nums[mid + 1]){
                end =  mid;
            }else{
                start = mid + 1;
            }
        }

        return nums[start];
    }
}
