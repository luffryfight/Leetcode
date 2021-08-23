package cn.kobe;

public class Solution {
    /*深度遍历,一次过nice*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int hegith = 0;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root, 0);
        return hegith;
    }

    private void dfs(TreeNode root, int high) {
        if (root == null) {
            hegith = Math.max(high, hegith);
            return;
        } else {
            dfs(root.left, high + 1);

            dfs(root.right, high + 1);
        }
    }
}
