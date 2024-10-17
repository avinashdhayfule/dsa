package TopKElements;

import java.util.PriorityQueue;

public class SumOfElements {
    public static void main(String[] args) {
        System.out.println(findSumOfElements(new int[]{1, 3, 12, 5, 15, 11}, 3, 6));
        System.out.println(findSumOfElements(new int[]{3, 5, 8, 7}, 1, 4));
    }
    public static int findSumOfElements(int[] nums, int k1, int k2){
         int sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
         for(int num : nums){
             minHeap.add(num);
         }

        for (int i = 0; i < k1; i++) {
            minHeap.poll();
        }

        for (int i = k1; i < k2 - 1; i++) {
            sum += minHeap.poll();
        }
        return sum;
    }
}
