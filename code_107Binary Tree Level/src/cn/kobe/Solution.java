package cn.kobe;

import java.util.*;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //3,9,20,1,1,15,7
    //先层序遍历一次存入，然后再存入另外一个
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queues = new ArrayDeque<>();
        List<List<Integer>> temp = new LinkedList<>();

        queues.offer(root);
        while (!queues.isEmpty()) {
            int size = queues.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode ch = queues.poll();
                list.add(ch.val);
                if (ch.left != null)
                    queues.offer(ch.left);
                if (ch.right != null)
                    queues.offer(ch.right);
            }
            temp.add(list);
        }
        int size = temp.size();
        for (int i = size - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
        return res;
    }
}
