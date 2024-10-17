package BinarySearch;

public class SearchMinDiffKey {
    public static void main(String[] args) {
        System.out.println(findMinDiffKey(new int[]{4, 6, 10} , 7 ));
        System.out.println(findMinDiffKey(new int[]{4, 6, 10} , 16 ));
        System.out.println(findMinDiffKey(new int[]{4, 6, 10} , 4 ));
        System.out.println(findMinDiffKey(new int[]{1, 3, 8, 10, 15} , 12 ));
    }
    public static int findMinDiffKey(int[] nums, int key){

        if(key < nums[0]) return nums[0];

        if(key > nums[nums.length - 1]) return nums[nums.length - 1];

        int start = 0; int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(key < nums[mid]){
                end = mid - 1;
            }else if(key > nums[mid]){
                start = mid + 1;
            }else{
                return nums[mid];
            }
        }

        if(nums[start] - key < key - nums[end]) return nums[start];

        return nums[end];
    }
}
