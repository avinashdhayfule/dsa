package src.TreeBFS;


import java.util.LinkedList;
import java.util.Queue;


public class LevelOrderSuccessor {

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

        TreeNode key = root.right.left; // node 24

        TreeNode res = levelOrderSuccessor(root, key);

        if (res != null)
            System.out.println("LevelOrder successor of "
                    +key.val + " is " + res.val);
        else
            System.out.println("LevelOrder successor of "
                    +key.val + " is NULL");
    }

    public static TreeNode levelOrderSuccessor(TreeNode root, TreeNode key){
        if(root == null) return null;

        if(root == key){
            if(root.left != null){
                return root.left;
            }

            if(root.right != null){
                return root.right;
            }

            return null;

        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

            if(node == key){
                break;
            }

        }

        return queue.peek();
    }
}
