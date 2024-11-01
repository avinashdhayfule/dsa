package src.InPlaceLinkedListReversal;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0) return head;

        int size = 0;
        ListNode lastNode = null;
        ListNode curr = head;
        while(curr != null){
            lastNode = curr;
            curr = curr.next;
            size++;
        }
        k = k % size;
        int skipLength = size - k;

        lastNode.next = head;

        ListNode lastNodeOftheNewList = head;
        for (int i = 0; i < skipLength - 1; i++) {
            lastNodeOftheNewList = lastNodeOftheNewList.next;
        }

        head = lastNodeOftheNewList.next;
        lastNodeOftheNewList.next = null;
        return head;
    }
}
