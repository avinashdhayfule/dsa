package src.TreeBFS;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    public int minDepth(TreeNode root) {


        if(root ==  null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int treeMinheight = 0;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            treeMinheight++;
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null)
                    return treeMinheight;
                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }

        }
        return treeMinheight;
    }
}
