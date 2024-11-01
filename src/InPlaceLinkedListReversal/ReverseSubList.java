package src.InPlaceLinkedListReversal;

public class ReverseSubList {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left == right)
            return head;

        ListNode curr = head;
        ListNode prev = null;

        for(int pos = 0;curr != null && pos < left - 1;++pos ){
            prev = curr;
            curr = curr.next;
        }

        ListNode lastNodeOfFirstPart = prev;
        ListNode lastNodeOfSecondPart = curr;
        ListNode next = null;

        for(int i = 0; curr != null && i < right - left + 1; i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        if(lastNodeOfFirstPart != null){
            lastNodeOfFirstPart.next = prev;
        }
        else{
            head = prev;
        }

        lastNodeOfSecondPart.next = curr;

        return head;
    }
}
