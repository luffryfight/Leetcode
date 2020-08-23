package cn.kobe;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }
    //还是比较满意
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
    private boolean dfs(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }else if(t1==null&&t2==null)
            return false;
        return t1.val==t2.val&&dfs(t1.left,t2.left)&&dfs(t1.right,t2.right);
    }
}
