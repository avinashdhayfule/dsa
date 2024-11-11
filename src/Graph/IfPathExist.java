package src.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IfPathExist {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj =  new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[adj.size()];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            if(node == destination) return true;

            for(int vertice : adj.get(node)){
                if(!visited[vertice]){
                    visited[vertice] = true;
                    queue.offer(vertice);
                }

            }
        }
        return false;
    }
}
