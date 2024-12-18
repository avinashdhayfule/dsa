package src.KWayMerge;

import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a , b) -> a.val - b.val);

        for(ListNode root: lists){
            if(root != null){
                minHeap.add(root);
            }
        }

        ListNode head = null;
        ListNode tail = null;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            if(head == null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                tail = tail.next;
            }

            if(node.next != null){
                minHeap.add(node.next);
            }
        }

        return head;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
