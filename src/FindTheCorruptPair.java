import java.util.Arrays;

public class FindTheCorruptPair {
    public static void main(String[] args) {
        int[] result = new int[2];
        //int [] nums = {3, 1, 2, 5, 2};
        int [] nums = {3, 1, 2, 3, 6, 4};
        int i = 0;
        while(i< nums.length){
            int j = nums[i] - 1;

            if(nums[i] != nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else{
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {

            if(nums[j] != j+1){
                result[0] = nums[j];
                result[1] = j + 1;
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
