package TopKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctElements {
    public static void main(String[] args) {
        System.out.println(findMaximumDistinctElements(new int[]{7, 3, 5, 8, 5, 3, 3}, 2));
        System.out.println(findMaximumDistinctElements(new int[]{3, 5, 12, 11, 12}, 3));
        System.out.println(findMaximumDistinctElements(new int[]{1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5}, 2));
    }

    public static int findMaximumDistinctElements(int[] nums, int k){
        int distinctElements = 0;
        if(nums.length < k)
            return distinctElements;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1,e2) -> e1.getValue() - e2.getValue());

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() == 1){
                distinctElements++;
            }else{
                minHeap.add(entry);
            }
        }

        while(k > 0 && !minHeap.isEmpty()){
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            int frequency = entry.getValue();

            k -=  frequency - 1;

            if(k > 0)
                distinctElements++;

        }

        if(k > 0){
            distinctElements = distinctElements - k;
        }

        return distinctElements;
    }
}
