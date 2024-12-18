package src.BitWise;

public class singleNumberII {
    public int[] singleNumber(int[] nums) {
        int n1xn2 = 0;
        for(int num : nums){
            n1xn2 = num ^ n1xn2;
        }

        int rightMostBit = 1;

        while((n1xn2 & rightMostBit ) == 0){
            rightMostBit = rightMostBit << 1;
        }
        int num1 = 0; int num2 = 0;
        for(int num : nums){
            if(( num & rightMostBit) != 0){
                num1 = num1 ^ num;
            }else{
                num2 = num2 ^ num;
            }
        }

        return new int[]{num1, num2};
    }
}
