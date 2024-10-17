package TopKElements;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static void main(String[] args) {
        System.out.println(minimumCostToConnectRopes(new int[]{1, 3, 11, 5}));
        System.out.println(minimumCostToConnectRopes(new int[]{3, 4, 5, 6}));
        System.out.println(minimumCostToConnectRopes(new int[]{1, 3, 11, 5, 2}));
    }
    public static int minimumCostToConnectRopes(int[] nums){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        int result = 0;
        while(minHeap.size() > 1){
            int temp = minHeap.poll() + minHeap.poll();
            result += temp;
            minHeap.add(temp);
        }

        return result;
    }
}
