package src.MonotonicStack;

import java.util.Stack;

public class RemoveKdigits {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack();

        for(char digit : num.toCharArray()){
            while(!stack.empty() && k > 0 && stack.peek() > digit ){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while(k > 0 && !stack.empty()){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }

        sb.reverse();

        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }
}
