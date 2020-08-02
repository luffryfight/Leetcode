package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    /*深度遍历,一次过nice*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int hegith=0;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.push(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode ch=queue.poll();
                if(ch.left!=null)   queue.push(ch.left);
                if(ch.right!=null)   queue.push(ch.right);
            }
            hegith++;
        }
        return hegith;
    }
}
