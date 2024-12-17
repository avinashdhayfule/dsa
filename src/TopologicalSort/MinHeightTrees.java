package src.TopologicalSort;

import java.util.*;

public class MinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        if(n <= 2){
            for(int i = 0; i < n ; i++){
                minHeightTrees.add(i);
            }

            return minHeightTrees;
        }

        HashMap<Integer, Integer> inDeegrees = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> adjacancy = new HashMap<>();

        for(int i = 0; i < n; i++){
            inDeegrees.put(i, 0);
            adjacancy.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int e1 = edges[i][0];
            int e2 = edges[i][1];
            adjacancy.get(e1).add(e2);
            adjacancy.get(e2).add(e1);
            inDeegrees.put(e1, inDeegrees.get(e1) + 1);
            inDeegrees.put(e2, inDeegrees.get(e2) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry : inDeegrees.entrySet()){
            if(entry.getValue() == 1){
                queue.add(entry.getKey());
            }
        }

        int totalNodes = n;
        while(totalNodes > 2){
            int queueSize = queue.size();
            totalNodes -= queueSize;
            for(int i = 0; i< queueSize; i++){
                int vertex = queue.poll();

                for(int child : adjacancy.get(vertex)){
                    inDeegrees.put(child, inDeegrees.get(child) - 1);

                    if(inDeegrees.get(child) == 1){
                        queue.add(child);
                    }
                }
            }
        }

        for(int vertex : queue){
            minHeightTrees.add(vertex);
        }

        return minHeightTrees;

    }
}
