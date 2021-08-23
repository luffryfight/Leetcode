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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] post, int head, int tail,
                          int[] ints, int start, int end) {
        if (start >= end) return null;

        int root_val = post[tail];
        TreeNode root = new TreeNode(root_val);
        //找到对应位置
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (root_val == ints[i]) {
                index = i;
                break;
            }
        }
        int size = index - head;
        //递归调用
        root.left = build(post, head, head + size - 1, ints, start, index - 1);
        root.right = build(post, head + size, end - 1, ints, index + 1, end);
        return root;
    }

    public static void main(String[] args) {

    }
}
