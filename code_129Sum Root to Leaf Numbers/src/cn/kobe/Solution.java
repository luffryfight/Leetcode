package cn.kobe;

/**
 * 作用：递归嘛，一般般
 * 2020/10/29
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);

        return res;
    }

    public void dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {//必须是叶子节点
            res += num;
        }
        if (root.left != null) {
            dfs(root.left, num * 10 + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, num * 10 + root.right.val);
        }
    }
}
