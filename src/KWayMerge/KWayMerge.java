package KWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KWayMerge {
    public static void main(String[] args) {
        Integer[] l1 = {2, 6, 8};
        Integer[] l2 = {3, 6, 7};
        Integer[] l3 = {1, 3, 4};
        List<Integer[]> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        System.out.println(findKWayMerge(list, 5));

        Integer[] ll1 = {5, 8, 9};
        Integer[] ll2 = {1, 7};
        list.clear();
        list.add(ll1);
        list.add(ll2);
        System.out.println(findKWayMerge(list, 3));
    }
    public static int findKWayMerge(List<Integer[]> lists, int k){
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1,n2) -> lists.get(n1.arrayIndex)[n1.index] - lists.get(n2.arrayIndex)[n2.index]);

        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new Node(0, i));
        }

        int smallestIndex = 0;

        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            smallestIndex++;

            if(smallestIndex == k)
                return lists.get(node.arrayIndex)[node.index];

            node.index++;
            if(lists.get(node.arrayIndex).length > node.index){
                minHeap.add(node);
            }
        }

        return 0;

    }
}
class Node{
    int index;
    int arrayIndex;

    public Node(int index, int arrayIndex){
        this.index = index;
        this.arrayIndex = arrayIndex;
    }
}
