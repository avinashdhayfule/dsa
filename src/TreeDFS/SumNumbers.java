package src.TreeDFS;

public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        if(root == null ) return 0;
        return sumNumbersHelper(root, 0);
    }
    public int sumNumbersHelper(TreeNode root, int pathSum) {

        if(root == null ) return 0;

        pathSum = pathSum * 10 + root.val;

        if(root.left == null && root.right == null)
            return pathSum;

        return sumNumbersHelper(root.left, pathSum) + sumNumbersHelper(root.right, pathSum);
    }
}
