package src.Graph;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                provinces++;
                dfs(isConnected, visited, i);
            }
        }

        return provinces;
    }

    public void dfs(int[][] connected, boolean[] visited, int source){
        visited[source] = true;

        for (int i = 0; i < connected[source].length; i++) {
            if(!visited[i] && connected[source][i] == 1){
                visited[i] = true;
                dfs(connected, visited, i);
            }
        }
    }
}
