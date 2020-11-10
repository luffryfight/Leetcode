package cn.kobe;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    List<Integer> res=new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return res;
        }
        getMidTravle(root);
        return res;
    }
    private void getMidTravle(TreeNode root){
        if(root!=null){
            getMidTravle(root.left);
            res.add(root.val);
            getMidTravle(root.right);
        }
    }
}
