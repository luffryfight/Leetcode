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

    //反正状态转移方程对了
    public int rob(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(root.val + dfs(root.left, false) + dfs(root.right, false)
                , dfs(root.left, true) + dfs(root.right, true));
    }

    private int dfs(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (flag) {
            return root.val + dfs(root.left, false) + dfs(root.right, false);
        }
        return dfs(root.left, true) + dfs(root.right, true);
    }
}
