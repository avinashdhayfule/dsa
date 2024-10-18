package src.TopologicalSort;

import com.sun.tools.javac.Main;

import java.util.*;

public class CourseScheduleOrder {
    public static void main(String[] args) {
        int[] arr = findOrder(1, new int[][]{});
        System.out.println(arr);
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> sortedOrder = new ArrayList<>();

        if(numCourses <= 0) return new int[0];

        HashMap<Integer, Integer> inDeegrees = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> adjacancy = new HashMap<>();

        for(int i = 0 ; i < numCourses; i++){
            inDeegrees.put(i, 0);
            adjacancy.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int child = prerequisites[i][0];
            int parent = prerequisites[i][1];

            adjacancy.get(parent).add(child);
            inDeegrees.put(child, inDeegrees.get(child) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : inDeegrees.entrySet()){
            if(entry.getValue() == 0){
                queue.offer(entry.getKey());
            }
        }
        int index = 0;
        boolean flag = false;
        while(!queue.isEmpty()){
            int vertice = queue.poll();
            sortedOrder.add(vertice);

            for(int child : adjacancy.get(vertice)){
                inDeegrees.put(child, inDeegrees.get(child) - 1);

                if(inDeegrees.get(child) == 0){
                    queue.add(child);

                }

            }
            flag = true;
        }

        if(sortedOrder.size() != numCourses) return new int[0];

        int[] result = new int[sortedOrder.size()];
        for (int i = 0; i < sortedOrder.size(); i++) {
            result[i] = sortedOrder.get(i);
        }

        return result;
    }
}
