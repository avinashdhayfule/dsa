package src.SlowAndFastPointers;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headOfSecondHalf = reverse(slow);
        ListNode headOfFirstHalf =  head;

        while(headOfFirstHalf != null && headOfSecondHalf != null){
            ListNode temp = headOfFirstHalf.next;
            headOfFirstHalf.next = headOfSecondHalf;
            headOfFirstHalf = temp;

            temp = headOfSecondHalf.next;
            headOfSecondHalf.next = headOfFirstHalf;
            headOfSecondHalf = temp;
        }

        if(headOfFirstHalf != null)
            headOfFirstHalf.next = null;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null ;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
