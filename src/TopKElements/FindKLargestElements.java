package TopKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKLargestElements {

    public static void main(String[] args) {
        System.out.println(findKLargestNumbers(new int[]{3,2,1,5,6,4}, 2));
    }
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);

        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        System.out.println(minHeap.peek());
        return new ArrayList<>(minHeap);
    }
}
