package src.Subsets;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if( n <= 0) return new ArrayList<>();

        return generateTreesHelper(1, n);
    }

    public List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null);
            return result;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> leftPart = generateTreesHelper(start, i - 1);
            List<TreeNode> rightPart = generateTreesHelper(i + 1, end);
            for(TreeNode left : leftPart){
                for(TreeNode right : rightPart){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }

            }
        }
        return result;
    }
}
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

