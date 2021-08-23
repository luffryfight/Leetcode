package cn.kobe;

import java.awt.color.ProfileDataException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            dfs(root.right);
            res.add(root.val);
        }
    }
}
