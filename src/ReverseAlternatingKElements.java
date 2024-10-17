
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    ListNode(int val, ListNode node){
        this.val = val;
        this.next = node;
    }
}

public class ReverseAlternatingKElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        reverseAlternateKElements(head , 3);
    }

    private static void reverseAlternateKElements(ListNode head, int k) {

        ListNode curr = head;
        ListNode prev = null;


        while(true){
            ListNode lastNodeOfFirstPart = prev;
            ListNode lastNodeOfSubset = curr;
            ListNode next = null;
            for(int i = 0 ; curr !=null && i < k; i++){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if(lastNodeOfFirstPart != null){
                lastNodeOfFirstPart.next = prev;
            }else{
                head = prev;
            }

            lastNodeOfSubset.next = curr;

            for(int i = 0 ; curr !=null && i < k; i++) {
                prev = curr;
                curr = curr.next;
            }

            if(curr == null)
                break;
        }

        ListNode node = head;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }



    }

}


