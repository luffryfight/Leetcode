package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    //进阶版本:迭代法
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode temp = root;
        while (temp != null || stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            TreeNode cur = stack.peek();
            System.out.println(cur.val);
            stack.pop();
            res.add(cur.val);
            temp = cur.right;
        }
        return res;
    }
}
