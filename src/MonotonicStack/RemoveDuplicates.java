package src.MonotonicStack;

import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();

        for(int i = 0; i < s.length(); i++){


            if(!stack.empty() && s.charAt(i) == stack.peek()){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }

        }

        StringBuilder result = new StringBuilder();
        while(!stack.empty()){
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
