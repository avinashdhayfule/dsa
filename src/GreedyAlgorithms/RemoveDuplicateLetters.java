package src.GreedyAlgorithms;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        char[] chs = s.toCharArray();
        int[] lastIndex = new int[26];
        for(int i = 0; i < chs.length; i++){
            lastIndex[chs[i] - 'a'] = i;
        }

        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < chs.length; i++ ){
            if(visited[chs[i] - 'a']) continue;

            while(!stack.isEmpty() && stack.peek() > chs[i] && i < lastIndex[stack.peek() - 'a']) {
                char ch = stack.pop();
                visited[ch - 'a'] = false;
            }

            stack.push(chs[i]);
            visited[chs[i] - 'a'] = true;
        }
        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
