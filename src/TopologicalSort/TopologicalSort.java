package src.TopologicalSort;

import java.util.*;

public class TopologicalSort {

    public static List<Integer> sort(int vertices, int[][] edges){
        List<Integer> sortedOrder = new ArrayList<>();

        if(vertices <= 0){
            return sortedOrder;
        }

        HashMap<Integer, Integer> inDeegree = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> adjancancy = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            inDeegree.put(i, 0);
            adjancancy.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            adjancancy.get(parent).add(child);
            inDeegree.put(child, inDeegree.get(child) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer>  entry: inDeegree.entrySet()){
            if(entry.getValue() == 0){
                queue.offer(entry.getKey());
            }
        }

        while(!queue.isEmpty()){
            int vertice = queue.poll();
            sortedOrder.add(vertice);

            List<Integer> childs = adjancancy.get(vertice);
            for(int child : childs){
                inDeegree.put(child, inDeegree.get(child) - 1);

                if(inDeegree.get(child) == 0){
                    queue.add(child);
                }
            }
        }

        if(sortedOrder.size() != vertices)
            return new ArrayList<>();

        return sortedOrder;
    }

    public static void main(String[] args) {
        System.out.println(sort(4, new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0},new int[] {2, 1}}));
    }
}
