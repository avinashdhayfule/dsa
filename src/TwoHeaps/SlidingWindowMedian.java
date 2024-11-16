package src.TwoHeaps;

import java.util.PriorityQueue;

public class SlidingWindowMedian {
    PriorityQueue<Integer> minheap = new PriorityQueue<>((a, b) -> a - b);
    PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> b - a);
    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double [nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){

            if(maxheap.isEmpty() || maxheap.peek() >= nums[i])
                maxheap.add(nums[i]);
            else
                minheap.add(nums[i]);

            rebalanceHeap();

            if(i - k + 1 >= 0 ){
                double median;
                if(maxheap.size() == minheap.size()){
                    median = ((double)maxheap.peek() + (double)minheap.peek())/2;
                }else{
                    median = maxheap.peek();
                }

                result[i - k + 1] = median;

                int numToBeRemoved =  nums[i - k + 1];
                if(numToBeRemoved <= maxheap.peek()){
                    maxheap.remove(numToBeRemoved);
                }else{
                    minheap.remove(numToBeRemoved);
                }
                rebalanceHeap();
            }



        }

        return result;
    }

    public void rebalanceHeap(){
        if(maxheap.size() > minheap.size() + 1){
            minheap.add(maxheap.poll());
        }else if(maxheap.size() < minheap.size()){
            maxheap.add(minheap.poll());
        }
    }
}
