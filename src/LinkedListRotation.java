public class LinkedListRotation {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode node =  rotateRight(head, 2);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {

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
