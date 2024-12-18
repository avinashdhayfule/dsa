package src.KWayMerge;

import java.util.PriorityQueue;

public class KthSmallestNumber {
    public static int mThLargest(int[][] arr, int m) {

        // Create a min heap. Every
        // heap node has first element of an array
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(arr[i][0], i, 0));
        }

        // Now one by one get the minimum element
        // from min heap and replace it with next
        // element of its array
        int count = 0;
        int i=0;
        int j=0;
        while (count < m && !pq.isEmpty()) {
            Pair curr = pq.poll();

            // i ==> Array Number
            // j ==> Index in the array number
            i = curr.arrayNumber;
            j = curr.index;

            // The next element belongs to same array as current.
            if (j + 1 < arr[i].length) {
                pq.add(new Pair(arr[i][j + 1], i, j + 1));
            }
            count++;
        }
        return arr[i][j];
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] arr = { { 2, 6, 12 }, { 1, 9 }, { 23, 34, 90, 2000 } };
        int m = 4;
        System.out.println(mThLargest(arr, m));
    }
}

class Pair implements Comparable<Pair> {
    int value;
    int arrayNumber;
    int index;

    // Constructor
    public Pair(int v, int i, int j) {
        value = v;
        arrayNumber = i;
        index = j;
    }

    // Compare two pair according to their values.
    public int compareTo(Pair o) {
        return this.value - o.value;
    }
}
