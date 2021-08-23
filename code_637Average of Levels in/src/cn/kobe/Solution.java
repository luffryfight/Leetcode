package cn.kobe;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //思路简单.
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode ch = queue.poll();
                sum += ch.val;
                if (ch.left != null) {
                    queue.offer(root.left);
                }
                if (ch.right != null) {
                    queue.offer(root.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
