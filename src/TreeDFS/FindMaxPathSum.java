package src.TreeDFS;

public class FindMaxPathSum {
    int globalSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return globalSum;
    }

    public int findMaxPathSum(TreeNode root) {

        if(root == null) return 0;

        int leftTreeSum = findMaxPathSum(root.left);
        int rightTreeSum = findMaxPathSum(root.right);

        leftTreeSum = Math.max(leftTreeSum, 0);
        rightTreeSum = Math.max(rightTreeSum, 0);

        int  localPathSum = leftTreeSum + rightTreeSum + root.val;
        globalSum = Math.max(globalSum, localPathSum);

        return Math.max(leftTreeSum, rightTreeSum) + root.val;
    }
}
