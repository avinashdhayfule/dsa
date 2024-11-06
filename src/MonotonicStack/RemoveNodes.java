package src.MonotonicStack;

import java.util.Stack;

public class RemoveNodes {
    public ListNode removeNodes(ListNode head) {

        if(head == null) return head;

        Stack<ListNode> stack = new Stack();

        ListNode curr = head;

        while(curr != null){
            int val = curr.val;
            while(!stack.empty() && curr.val > stack.peek().val){
                stack.pop();
            }

            stack.push(curr);
            curr = curr.next;
        }

        ListNode next = null;

        while(!stack.empty()){
            curr = stack.pop();
            curr.next = next;
            next = curr;
        }

        head = curr;

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
