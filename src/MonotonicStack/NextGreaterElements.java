package src.MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElements {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map  = new HashMap<>();
        for(int i = nums2.length - 1; i > -1; i--){

            int num = nums2[i];

            while(!stack.isEmpty() && num > stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                map.put(num, -1);
            }else{
                map.put(num, stack.peek());
            }

            stack.push(num);


        }

        int[] result = new int[nums1.length];
        for(int i =0 ; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                result[i] = map.get(nums1[i]);
            }
        }

        return result;
    }
}
