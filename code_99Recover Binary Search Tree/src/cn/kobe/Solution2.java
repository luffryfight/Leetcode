package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

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

    class Solution {
        public void recoverTree(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            TreeNode x = null, y = null, pred = null;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (pred != null && pred.val > root.val) {
                    y = root;
                    if (x == null) {
                        x = pred;
                    } else break;
                }
                pred = root;
                root = root.right;
            }

            swap(x, y);
        }

        public void swap(TreeNode x, TreeNode y) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }
}
