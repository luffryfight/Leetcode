package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    //简单点就是直接保存节点上的数
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Deque<Integer> stack = new ArrayDeque<>();
    boolean flag = true;

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
