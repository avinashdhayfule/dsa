package src.TwoPointers;

public class RemoveDuplicatesFromSortedArray_II {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println("Another testcase");
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 2 ){
            return nums.length;
        }

        int left = 2;
        for(int right = 2; right< nums.length; right++){
            if(nums[left - 2] != nums[right]){
                nums[left] = nums[right];
                left++;
            }

        }
        return left;
    }
}
