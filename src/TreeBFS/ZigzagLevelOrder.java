package src.TreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root ==  null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> levelList = new ArrayList<>(queueSize);

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if(leftToRight) {
                    levelList.add(node.val);
                }else{
                    levelList.add(0, node.val);
                }

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }

            result.add(levelList);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
