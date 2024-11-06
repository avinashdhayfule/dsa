package src.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementsII {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        Stack<Integer> stack =  new Stack<>();

        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        for(int index = 2 * length - 1; index > - 1; index--){

            while(!stack.isEmpty() && nums[index % length] >= stack.peek()){
                stack.pop();
            }

            if(!stack.isEmpty() && index < length ){
                result[index] = stack.peek();
            }

            stack.push(nums[index%length]);
        }

        return result;
    }
}
