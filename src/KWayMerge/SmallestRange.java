package src.KWayMerge;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> lists) {
        PriorityQueue<Node1> minHeap = new PriorityQueue<>((n1, n2) -> lists.get(n1.arrayIndex).get(n1.index) - lists.get(n2.arrayIndex).get(n2.index));

        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i) != null){
                minHeap.add(new Node1(0, i));
                maxNumber = Math.max(maxNumber, lists.get(i).get(0));
            }

        }

        int start = 0;
        int end =  Integer.MAX_VALUE;

        while(minHeap.size() == lists.size()){
            Node1 node = minHeap.poll();
            int num =  lists.get(node.arrayIndex).get(node.index);

            if(end - start > maxNumber - num){
                end = maxNumber;
                start =  num;
            }

            node.index++;
            if(lists.get(node.arrayIndex).size() > node.index){
                minHeap.add(node);
                maxNumber = Math.max(maxNumber, lists.get(node.arrayIndex).get(node.index));
            }
        }

        return new int[]{start , end};
    }
}

class Node1{
    int index;
    int arrayIndex;

    public Node1(int index, int arrayIndex){
        this.index = index;
        this.arrayIndex = arrayIndex;
    }
}
