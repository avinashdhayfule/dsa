import java.util.Arrays;
import java.util.Stack;

public class ReverseOfStringUsingStack {

    public static void main(String[] args) {
        String s ="abcd";
        reverse(s.toCharArray());
    }

    public static void reverse(char[] s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }

        for (int i = 0; i < s.length; i++) {
            if(!stack.isEmpty()){
                s[i] = stack.pop();
            }
        }

        System.out.println(Arrays.toString(s));

    }
}
