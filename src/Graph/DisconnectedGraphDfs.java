package Graph;

import java.util.ArrayList;
import java.util.List;


public class DisconnectedGraphDfs {

    public static void main(String[] args) {
        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = { { 1, 2 }, { 2, 0 }, { 0, 3 }, { 4, 5 } };

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            addEdge(adj, edge[0], edge[1]);
        }

        dfs(adj);
    }

    private static void dfs(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < 5; i++) {
            if( !visited[i]){
                dfsRec(adj, visited, i);
            }
        }
    }

    private static void dfsRec(List<List<Integer>> adj, boolean[] visited, int s) {
        visited[s] = true;
        System.out.println("Visiting the node "+s);
        for (int edge : adj.get(s)){
            if(!visited[edge])
                dfsRec(adj, visited, edge);
        }

    }

    private static void addEdge(List<List<Integer>> adj, int s, int e) {
        adj.get(s).add(e);
        adj.get(e).add(s);
    }
}
