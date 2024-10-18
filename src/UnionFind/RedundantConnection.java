package src.UnionFind;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {

        UnionFindPattern unionFind = new UnionFindPattern(edges.length);

        for(int[] edge : edges){
            if(!unionFind.union(edge[0] - 1, edge[1] - 1))
                return new int[]{edge[0], edge[1]};
        }

        return new int[0];
    }
}
class UnionFindPattern {

    int[] representative;
    int[] size;
    public UnionFindPattern(int n){
        representative = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
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

