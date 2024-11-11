package src.TreeBFS;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root ==  null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int treeheight = 0;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            treeheight++;
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return treeheight;
    }
}
