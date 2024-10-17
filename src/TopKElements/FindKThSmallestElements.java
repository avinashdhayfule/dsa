package TopKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKThSmallestElements {

    public static void main(String[] args) {
        System.out.println(findKLargestNumbers(new int[]{3,2,1,5,6,4}, 6));
    }
    public static Integer findKLargestNumbers(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if(nums[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
        return maxHeap.peek();
    }
}
