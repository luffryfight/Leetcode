package cn.kobe;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用：Moris算法
 * 使用时先回忆一下该算法
 * 2020/10/27
 */
public class Solution2 {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode temp = root;
        while (temp != null) {
            TreeNode l = temp.left;
            if (l != null) {
                while (l.right != null && l.right != temp) {
                    l = l.right;
                }
                if (l.right == null) {
                    res.add(temp.val);
                    temp = temp.left;
                    l.right = temp;
                    continue;
                } else {
                    l.right = null;
                }
            } else {
                res.add(temp.val);
            }
            temp = temp.right;
        }
        return res;
    }
}
