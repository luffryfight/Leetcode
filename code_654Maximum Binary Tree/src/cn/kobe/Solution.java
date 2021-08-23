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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    //左闭右开(临界点判断，只要自己设置好了，每个点都照做就好了)
    public TreeNode buildTree(int[] nums, int l, int r) {
        if (l >= r) return null;
        int max = nums[l], index = l;

        for (int i = l; i < r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(nums, l, index);
        root.right = buildTree(nums, index + 1, r);

        return root;
    }
}
