package src.TwoHeaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];

        for(int i = 0; i< n; i++){
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> maxprofitheap = new PriorityQueue<>((a, b) -> b - a);
        int index = 0;
        for(int i = 0; i < k; i++){
            while(index < n && projects[index][0] <= w){
                maxprofitheap.add(projects[index][1]);
                index++;
            }

            if(maxprofitheap.isEmpty()) break;

            w +=  maxprofitheap.poll();
        }
        return w;
    }
}
