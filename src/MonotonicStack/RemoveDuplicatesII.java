package src.MonotonicStack;

import java.util.Stack;

public class RemoveDuplicatesII {
    public String removeDuplicates(String s, int k) {
        Stack<CharCounter> stack = new Stack();

        for(int i = 0; i < s.length(); i++){

            if(!stack.empty() && stack.peek().c == s.charAt(i)){
                if(stack.peek().count < k - 1 ){
                    stack.peek().count++;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(new CharCounter(s.charAt(i)));
            }

        }

        StringBuilder sb = new StringBuilder();

        while(!stack.empty()){
            CharCounter cc = stack.pop();
            for(int i = 0; i < cc.count; i++){
                sb.append(cc.c);
            }

        }

        return sb.reverse().toString();
    }
}

class CharCounter{
    int count;
    char c;

    public CharCounter(char c){
        this.c = c;
        this.count = 1;
    }
}
