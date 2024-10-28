package src.SlowAndFastPointers;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headOfSecondHalf = reverse(slow);

        while(head != null && headOfSecondHalf != null){

            if (head.val != headOfSecondHalf.val)
                return false;

            head = head.next;
            headOfSecondHalf = headOfSecondHalf.next;
        }


        if(head == null || headOfSecondHalf == null)
            return true;

        return false;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
