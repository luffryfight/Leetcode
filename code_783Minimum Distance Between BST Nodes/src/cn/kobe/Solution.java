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

    //中序的相邻项
    int pre = -1;
    int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);

        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            res = Math.min(Math.abs(root.val - pre), res);
        }
        pre = root.val;
        dfs(root.right);
    }
}
