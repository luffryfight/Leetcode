package cn.kobe;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author 86137
 * @date 2021/8/23 11:04
 * TODO:
 */
public class Main {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return null;
        boolean flag=true;// true is root.right first
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.addFirst(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> tempList=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode top=queue.pollFirst();
                tempList.add(top.val);
                if(flag){//先放入右边的子树
                    if(top.right!=null)
                        queue.addFirst(top.right);
                    if(top.left!=null)
                        queue.addFirst(top.left);
                }else{
                    if(top.left!=null)
                        queue.addFirst(top.left);
                    if(top.right!=null)
                        queue.addFirst(top.right);
                }
            }
            res.add(tempList);
            flag= flag==true?false:true;
        }
        return res;
    }
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
}
