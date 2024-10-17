package Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphDfs {

    public static void main(String[] args) {
        int V = 5;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {
                { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 }
        };

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            addEdge(adj, edge[0], edge[1]);

        }
        
        int source = 1;
        System.out.println("DFS from source "+source);
        dfs(adj, source);
    }

    private static void dfs(List<List<Integer>> adj, int source) {
        boolean[] visited = new boolean[adj.size()];
        dfsRec(adj, visited, source);
    }

    private static void dfsRec(List<List<Integer>> adj, boolean[] visited, int source) {
        visited[source] = true;

        System.out.println(" Visited the node : "+ source);

        for (Integer edge : adj.get(source)){
            if(!visited[edge]) {
                dfsRec(adj, visited, edge);
            }
        }

    }
    private static void addEdge(List<List<Integer>> adj, Integer s, Integer e) {
        adj.get(s).add(e);
        adj.get(e).add(s);
    }
}
