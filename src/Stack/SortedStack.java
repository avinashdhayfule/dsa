package Stack;

import java.util.Stack;

public class SortedStack {
    public static void main(String[] args) {
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        Stack<Integer> stack = sortStack(input);
        System.out.println("Sorted numbers are:");

        while (!stack.empty())
        {
            System.out.print(stack.pop()+" ");
        }

        Character b = "a".charAt(0);
    }

    public static Stack<Integer> sortStack(Stack<Integer> input){
        Stack<Integer> temp = new Stack<>();
        while(input.size() > 0){
            int num = input.pop();

            while(!temp.empty() && num < temp.peek()){
                input.push(temp.pop());
            }

            temp.push(num);
        }

        return temp;
    }
}
