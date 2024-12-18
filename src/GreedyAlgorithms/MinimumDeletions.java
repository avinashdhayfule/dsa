package src.GreedyAlgorithms;

public class MinimumDeletions {
    public int minimumDeletions(int[] nums) {

        int minIndex = 0;
        int maxIndex = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if(nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int frontRemoval = Math.max(minIndex + 1, maxIndex + 1);
        int endRemoval = Math.max(nums.length - minIndex, nums.length - maxIndex);
        int frontAndEndRemoval = Math.min(minIndex + 1 +  nums.length - maxIndex, maxIndex + 1 + nums.length - minIndex);
        int frontOrEndRemoval = Math.min(frontRemoval, endRemoval);

        return Math.min(frontOrEndRemoval, frontAndEndRemoval);
    }
}
