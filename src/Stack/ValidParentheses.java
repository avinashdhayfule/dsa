package src.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}','{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);

            if(map.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                }else{
                    Character pop = stack.pop();
                    if(pop != map.getOrDefault(c,'a'))
                        return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
