package cn.kobe;

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

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {//root.left!=null
                TreeNode temp = root.left;
                //得到左子树的最右节点
                while (temp.right != null) {
                    temp = temp.right;
                }
                //将root.right连接到temp的右边
                temp.right = root.right;
                //交换root的左右节点
                root.right = root.left;
                //左边赋空
                root.left = null;
                //下一个节点
                root = root.right;
            }
        }
    }

}
