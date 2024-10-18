package src.UnionFind;

public class UnionFind {

    int[] representative;
    int[] size;
    public UnionFind(int n){
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

    public void union(int u, int v){
        u = find(u);
        v = find(v);
        if(u == v)
            return;

        if(size[u] > size[v]){
            representative[v] = u;
            size[v] += size[u];
        }else{
            representative[u] = v;
            size[u] += size[v];
        }
    }
    public boolean isConnected(int u, int v){
        return find(u) == find(v);
    }



}
