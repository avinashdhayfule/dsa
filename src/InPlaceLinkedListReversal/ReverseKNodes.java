package src.InPlaceLinkedListReversal;

public class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {

        if(k <= 1 || head == null) return head;

        ListNode curr = head;
        ListNode prev = null;


        while(true){
            ListNode lastIndexFirstPart = prev;
            ListNode lastIndexSublist = curr;
            ListNode next = null;
            for(int i = 0; curr != null && i < k ; i++){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if(lastIndexFirstPart != null){
                lastIndexFirstPart.next = prev;
            }else{
                head = prev;
            }

            lastIndexSublist.next = curr;

            if(curr == null)
                break;
            int numOfNodes = 0;
            ListNode node = curr;
            while(node!= null && numOfNodes < k){
                node = node.next;
                numOfNodes++;
            }

            if(numOfNodes < k)
                break;
            prev = lastIndexSublist;

        }

        return head;

    }
}
