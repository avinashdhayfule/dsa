package src.TwoHeaps;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        maxHeap = new PriorityQueue<>((a, b) -> b - a);

    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else{
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }


    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
            return (double)(maxHeap.peek() + minHeap.peek())/2;

        return maxHeap.peek();
    }
}
