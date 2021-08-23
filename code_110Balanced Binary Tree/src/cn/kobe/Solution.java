package cn.kobe;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = getDeepth(root.left);
        int r = getDeepth(root.right);
        if (Math.abs(r - l) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDeepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDeepth(root.left), getDeepth(root.right)) + 1;
    }
}
