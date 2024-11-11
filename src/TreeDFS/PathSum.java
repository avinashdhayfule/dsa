package src.TreeDFS;

public class PathSum {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return  pathSumHelper(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int pathSumHelper(TreeNode root, int targetSum, int sum) {
        if (root == null) return 0;


        sum += root.val;
        int counter = 0;
        if(sum == targetSum){
            counter = 1;
        }


        return  counter + pathSumHelper(root.left, targetSum, sum) +  pathSumHelper(root.right, targetSum, sum);
    }
}
