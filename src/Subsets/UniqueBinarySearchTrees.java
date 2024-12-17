package src.Subsets;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n <= 1) return 1;

        int count = 0;

        for(int i = 1; i <= n; i++){
            int leftCount = numTrees(i - 1);
            int rightCount = numTrees(n - i);
            count += (leftCount * rightCount);
        }

        return count;
    }
}
