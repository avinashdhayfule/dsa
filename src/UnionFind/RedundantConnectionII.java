package src.UnionFind;

public class RedundantConnectionII {

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int sizes = edges.length;

        int[] parent = new int[sizes + 1];
        int edgeRemoveIndex = -1;
        int edgeMakesCycleIndex = -1;
        UnionFindPatternII uf = new UnionFindPatternII(sizes);

        for(int i = 0; i < sizes; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(parent[v] != 0){
                edgeRemoveIndex = i;
                continue;
            }else{
                parent[v] = u;
            }

            if (!uf.union(u, v)) {
                edgeMakesCycleIndex = i;
                continue;
            }
        }

        if(edgeRemoveIndex == -1){
            return edges[edgeMakesCycleIndex];
        }

        if(edgeMakesCycleIndex != -1){
            int v = edges[edgeRemoveIndex][1];
            int u = parent[v];

            return new int[]{u, v};
        }

        return edges[edgeRemoveIndex];

    }
}

class UnionFindPatternII {

    int[] representative;
    int[] size;
    public UnionFindPatternII(int n){
        representative = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            representative[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u ){
        if(u == representative[u]){
            return u;
        }else{
            return representative[u] = find(representative[u]);
        }
    }

    public boolean union(int u, int v){
        u = find(u);
        v = find(v);

        if(u == v)
            return false;

        if(size[u] > size[v]){
            representative[v] = u;
            size[v] += size[u];
        }else{
            representative[u] = v;
            size[u] += size[v];
        }

        return true;
    }
}

