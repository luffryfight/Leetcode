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

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean dfs(TreeNode root, long max, long min) {
        if (root == null)
            return true;
        if (root.val >= max || root.val <= min)
            return false;
        return dfs(root.left, root.val, min) && dfs(root.right, max, root.val);
        //注意看传入的最大最小值
    }
}
