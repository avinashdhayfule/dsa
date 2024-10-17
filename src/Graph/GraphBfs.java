package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBfs {
    public static void main(String[] args) {
        int V = 5;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {{0,1}, {0,2},{1,3},{1,4}, {2,4}};

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            addEdge(adj, edge[0], edge[1]);
        }

        bfs(adj, 0);

    }

    private static void bfs(List<List<Integer>> adj, int source) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            System.out.println("Visited the node "+node);
            for (int vertice : adj.get(node)) {

                if(!visited[vertice]){
                    queue.offer(vertice);
                    visited[vertice] = true;
                }
            }
        }

    }

    private static void addEdge(List<List<Integer>> adj, int s, int e) {
        adj.get(s).add(e);
        adj.get(e).add(s);
    }
}
