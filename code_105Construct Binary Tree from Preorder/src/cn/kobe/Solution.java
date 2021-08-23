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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length,
                inorder, 0, inorder.length);
    }

    //还是左开右闭
    public TreeNode build(int[] pre, int head, int tail,
                          int[] in, int start, int end) {
        if (head >= tail) return null;
        //获取根节点和最左节点
        int root_val = pre[head];

        TreeNode root = new TreeNode(root_val);
        //从中序中找到跟根值
        int index = 0;
        for (int i = start; i < end; i++) {
            if (root_val == in[i]) {
                index = i;
                break;
            }
        }
        int size = index - start;//差值 +1 为个数
        root.left = build(pre, head + 1, head + size + 1, in, start, index);
        root.right = build(pre, head + size + 1, tail, in, index + 1, end);

        return root;
    }
}
