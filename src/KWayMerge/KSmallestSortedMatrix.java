package src.KWayMerge;

import java.util.PriorityQueue;

public class KSmallestSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        for (int i = 0; i < matrix.length ; i++) {
            minHeap.add(new Node(i, 0));
        }

        int smallestIndex = 0;

        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            smallestIndex++;

            if(smallestIndex == k)
                return matrix[node.row][node.col];

            node.col++;
            if(matrix[node.row].length > node.col){
                minHeap.add(node);
            }
        }

        return 0;
    }
}

class Node{
    int row;
    int col;

    public Node( int row, int col){
        this.row = row;
        this.col = col;
    }
}
