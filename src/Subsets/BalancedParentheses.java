package src.Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalancedParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<Parenthesis> queue = new LinkedList<>();
        queue.add(new Parenthesis("", 0 , 0));
        while(!queue.isEmpty()){
            Parenthesis curr = queue.poll();

            if(curr.openParenthesis == n && curr.closeParenthesis == n){
                result.add(curr.str);
            }else{
                if(curr.openParenthesis < n){
                    queue.add(new Parenthesis(curr.str + "(", curr.openParenthesis + 1 , curr.closeParenthesis ));
                }

                if(curr.closeParenthesis < curr.openParenthesis){
                    queue.add(new Parenthesis(curr.str + ")", curr.openParenthesis , curr.closeParenthesis + 1));
                }
            }
        }

        return result;
    }
}

class Parenthesis{
    String str;
    int openParenthesis;
    int closeParenthesis;
    public Parenthesis(String s, int openParenthesis, int closeParenthesis){
        this.str = s;
        this.openParenthesis = openParenthesis;
        this.closeParenthesis = closeParenthesis;
    }
}
