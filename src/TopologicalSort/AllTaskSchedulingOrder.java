package src.TopologicalSort;

import java.util.*;

public class AllTaskSchedulingOrder {
    public static void main(String[] args) {
        printOrder(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}});
        System.out.println("************************");
        printOrder(4, new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println("************************");
        printOrder(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4}, new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}});
    }

    public static void printOrder(int task, int[][] prerequisites){
        List<Integer> sortedOrder = new ArrayList<>();
        HashMap<Integer, Integer> inDeegrees = new HashMap<>();
        HashMap<Integer, List<Integer>> adjacancy = new HashMap<>();

        for (int i = 0; i < task; i++) {
            inDeegrees.put(i, 0);
            adjacancy.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            adjacancy.get(parent).add(child);
            inDeegrees.put(child, inDeegrees.get(child) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDeegrees.entrySet()) {
            if(entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }

        topologicalSort(queue, inDeegrees, adjacancy, sortedOrder);
    }

    private static void topologicalSort(Queue<Integer> queue, HashMap<Integer, Integer> inDeegrees, HashMap<Integer, List<Integer>> adjacancy, List<Integer> sortedOrder) {

        if(!queue.isEmpty()){
            for(int vertex: queue){
                sortedOrder.add(vertex);
                Queue queueClone = getClone(queue);

                queueClone.remove(vertex);
                List<Integer> childs = adjacancy.get(vertex);
                for(int child : childs){
                    inDeegrees.put(child, inDeegrees.get(child) - 1);
                    if(inDeegrees.get(child) == 0){
                        queueClone.add(child);
                    }
                }

                topologicalSort(queueClone, inDeegrees, adjacancy, sortedOrder);
                sortedOrder.remove((Integer)vertex);
                for(int child : childs){
                    inDeegrees.put(child, inDeegrees.get(child) + 1);
                }
            }
        }

        if(sortedOrder.size() == inDeegrees.size()){
            System.out.println(sortedOrder);
        }
    }

    private static Queue getClone(Queue<Integer> queue) {
        Queue<Integer> result = new LinkedList<>();
        for(int vertex : queue){
            result.add(vertex);
        }
        return result;
    }
}
