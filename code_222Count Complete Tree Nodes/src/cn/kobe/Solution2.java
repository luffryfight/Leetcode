package cn.kobe;

public class Solution2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //层序遍历，需要空间，且时间也不短
    //技巧判断:注意理解：如果左右层高相同就左边是满二叉树，反之右边是满二叉树
    //这个其实也是二分了
    public int countNodes(TreeNode root) {
        //终止条件！
        if (root == null) return 0;
        int left = getDeepth(root.left);
        int right = getDeepth(root.right);
        if (left == right) {
            return (1 << left) + countNodes(root.right);
        } else {
            return (1 << right) + countNodes(root.left);
        }
    }

    private int getDeepth(TreeNode root) {
        //因为是完全二叉树，所以只用向左遍历
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
