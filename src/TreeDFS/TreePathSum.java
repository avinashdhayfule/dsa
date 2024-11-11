package src.TreeDFS;

public class TreePathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        int num = root.val;
        if(num == targetSum && root.left == null && root.right == null){
            return true;
        }

        return hasPathSum(root.left, targetSum - num) ||  hasPathSum(root.right, targetSum - num);
    }
}
