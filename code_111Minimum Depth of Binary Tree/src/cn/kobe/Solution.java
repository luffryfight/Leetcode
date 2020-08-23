package cn.kobe;

public class Solution {
    //dfs
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    int res=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,1);
        return res;
    }
    private void dfs(TreeNode root,int level){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            res=Math.min(res,level);
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}
