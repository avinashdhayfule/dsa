package src.MonotonicStack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int [temperatures.length];
        Stack<Integer> stack = new Stack();

        for(int i = 0; i < temperatures.length ; i++){

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int top = stack.pop();
                result[top] = i - top;
            }

            stack.push(i);
        }

        return result;
    }
}
