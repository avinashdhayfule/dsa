package src.TopologicalSort;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return true;

        List<Integer> sortedOrder = new ArrayList<>();

        HashMap<Integer, Integer> inDeegrees = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> adjacancy = new HashMap<>();

        for(int i = 0 ; i < numCourses; i++){
            inDeegrees.put(i, 0);
            adjacancy.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];

            adjacancy.get(parent).add(child);
            inDeegrees.put(child, inDeegrees.get(child) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : inDeegrees.entrySet()){
            if(entry.getValue() == 0){
                queue.offer(entry.getKey());
            }
        }

        while(!queue.isEmpty()){
            int vertice = queue.poll();
            sortedOrder.add(vertice);

            for(int child : adjacancy.get(vertice)){
                inDeegrees.put(child, inDeegrees.get(child) - 1);

                if(inDeegrees.get(child) == 0){
                    queue.add(child);
                }
            }
        }

        return sortedOrder.size() == numCourses;

    }
}
