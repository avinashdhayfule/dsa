package KWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestPair {

    public static void main(String[] args) {
        int[] L1={9, 8, 2}; int[] L2={6, 3, 1};
        System.out.println(kSmallestPairs(L1, L2, 3));

        L1= new int[]{5, 2, 1}; L2= new int[]{2, -1};
        System.out.println(kSmallestPairs(L1, L2, 3));
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));
        int len1 = Math.min(k, nums1.length);
        int len2 = Math.min(k, nums2.length);
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(minHeap.size() < k){
                    List<Integer> li = new ArrayList<>();
                    li.add(nums1[i]);
                    li.add(nums2[j]);
                    minHeap.add(li);
                }else{
                    if(nums1[i] + nums2[j] <= minHeap.peek().get(0) +  minHeap.peek().get(1)){
                        break;
                    }else{
                        minHeap.poll();
                        List<Integer> li = new ArrayList<>();
                        li.add(nums1[i]);
                        li.add(nums2[j]);
                        minHeap.add(li);
                    }
                }
            }
        }

        return new ArrayList<List<Integer>>(minHeap);
    }
}
