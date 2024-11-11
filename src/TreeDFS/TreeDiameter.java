package src.TreeDFS;

public class TreeDiameter {
    int treeDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        heightOfBinaryTree(root);
        return treeDiameter;

    }

    public int heightOfBinaryTree(TreeNode root) {

        if(root == null) return 0;

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);

        int diameter = leftHeight + rightHeight;
        treeDiameter = Math.max(treeDiameter, diameter);

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
