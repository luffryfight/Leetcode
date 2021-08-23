package cn.kobe;


import java.util.*;

public class Solution2 {
    //迭代方法
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

    //别人的代码，优秀啊好好学习
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p != null) {
                list.addFirst(p.val);
                stack.push(p.left);
                stack.push(p.right);
            }
        }
        return list;
    }
}
