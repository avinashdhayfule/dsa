package src.UnionFind;

public class Bipartite {

    public boolean isBipartite(int[][] graph) {
        UnionFind uf = new UnionFind(graph.length);

        for(int i = 0; i < graph.length; i++){
            for(int j = 0 ; j < graph[i].length; j++ ){
                if(uf.isConnected(i, graph[i][j]))
                    return false;

                uf.union(graph[i][0], graph[i][j]);
            }

        }

        return true;
    }
}
