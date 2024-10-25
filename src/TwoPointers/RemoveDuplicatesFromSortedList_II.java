package src.TwoPointers;



public class RemoveDuplicatesFromSortedList_II{
    public static void main(String[] args) {
        //1,2,3,3,4,4,5
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, null)))))));
        print(deleteDuplicates(head));
        // 1,1,2
        print(deleteDuplicates(new ListNode(1, new ListNode(1,new ListNode(2, null)))));
    }

    private static void print(ListNode listNode) {
        System.out.println("Printing List as follows ....");
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while(node != null && node.next != null){

            boolean isDuplicate = false;
            while(node != null && node.next != null && node.val == node.next.val){
                node.next = node.next.next;
                isDuplicate = true;
            }

            if(isDuplicate){
                if(node == head){
                    head = node.next;
                }
                if(prev != null && node != null){
                    prev.next = node.next;
                }
            }else{
                prev = node;
            }
            node = node.next;


        }
        return head;
    }
}
