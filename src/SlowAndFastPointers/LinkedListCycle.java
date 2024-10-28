package src.SlowAndFastPointers;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode curr = head;
                int pos = -1;
                while(curr != null && slow != null){
                    curr = curr.next;
                    slow = slow.next;
                    pos++;

                    if(slow == curr)
                        return true;
                }

            }
        }

        return false;
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
