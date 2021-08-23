package cn.kobe;

import java.util.LinkedList;
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

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTree(0, n);
    }

    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> root = new LinkedList<>();
        if (start > end) {
            root.add(null);
            return root;
        }
        for (int i = start; i < end; i++) {
            List<TreeNode> lefttree = generateTree(start, i - 1);
            List<TreeNode> righttree = generateTree(start, i + 1);
            //这里遍历可以获得所有的情况
            for (int l = 0; l < lefttree.size(); l++) {
                for (int r = 0; r < righttree.size(); r++) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = lefttree.get(l);
                    newNode.right = righttree.get(r);
                    root.add(newNode);
                }
            }
        }
        return root;
    }
}
