package src.TwoPointers;



public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        print(deleteDuplicates(head));
    }
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode node = head;

        while(node != null && node.next != null){
            while(node != null && node.next != null && node.val == node.next.val){
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }

    private static void print(ListNode listNode) {
        System.out.println("Printing List ....");
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

