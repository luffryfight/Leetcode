package cn.kobe;

import org.omg.CORBA.TRANSACTION_MODE;

public class Solution {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    //还需要再理解一下，其实也不难，就是有点点需要get
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val<key){
            root.right=deleteNode(root.right,key);
            return root;//上面一步已经完成了删除，不用执行后面
        }
        if(root.val>key){
            root.left=deleteNode(root.left,key);
            return root;
        }
        //找到了,并且处理该节点
        if(root.left==null)
            return root.right;
        if(root.right==null)
            return root.left;
        //这里已经都不为空，找到右边最下
        TreeNode temp=root.right;
        while (temp.left!=null)
            temp=temp.left;
        //交换节点的值
        root.val=temp.val;
        root.right=deleteMin(root.right);
        return root;
    }
    public TreeNode deleteMin(TreeNode root){
        if(root.left==null){//找到了要删除的节点
            TreeNode pright=root.right;//返回该节点右边的节点连在父节点的左边
            root.right=null;
            return pright;
        }
        root.left=deleteMin(root.left);
        return root;
    }
}
