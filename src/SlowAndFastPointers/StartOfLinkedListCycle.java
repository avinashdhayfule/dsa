package src.SlowAndFastPointers;

public class StartOfLinkedListCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;


            if(slow == fast){
                ListNode curr = head;
                int pos = -1;
                while(curr != null && slow != null){

                    if(slow == curr)
                        return slow;

                    curr = curr.next;
                    slow = slow.next;
                    pos++;
                }

            }
        }

        return null;
    }
}
