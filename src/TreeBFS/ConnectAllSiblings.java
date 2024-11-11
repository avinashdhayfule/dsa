package src.TreeBFS;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(18);
        root.right = new TreeNode(26);
        root.right.left = new TreeNode(24);
        root.right.right = new TreeNode(27);
        root.left.right.left = new TreeNode(14);
        root.left.right.left.left = new TreeNode(13);
        root.left.right.left.right = new TreeNode(15);
        root.left.right.right = new TreeNode(19);

        TreeNode node = levelOrderSuccessor(root);
    }

    public static TreeNode levelOrderSuccessor(TreeNode root){
        if(root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode prev = null;
        while(!queue.isEmpty()){
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if(prev != null){
                    prev.next = node;
                    System.out.println("Next node of "+prev.val + " is "+prev.next.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                prev = node;
            }
            prev.next = null;
            System.out.println("Next node of "+prev.val + " is "+null);
        }

        return root;
    }
}
