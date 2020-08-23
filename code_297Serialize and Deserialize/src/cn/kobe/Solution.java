package cn.kobe;

public class Solution {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    StringBuilder sb=new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        dfs(root);
        //System.out.println(sb.toString());
        return sb.toString();
    }
    private void dfs(TreeNode root){
        if(root==null){
            sb.append("#").append(",");
        }else{
            sb.append(root.val).append(",");
            dfs(root.left);
            dfs(root.right);
        }
    }
    // Decodes your encoded data to tree.
    String[] str;
    int i=0;
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        str=data.split(",");
        return DFS();
    }
    private TreeNode DFS(){
        if(i==str.length)  return null;

        String first=str[i++];
        if(first.equals("#")) return null;

        TreeNode root=new TreeNode(Integer.parseInt(first));
        root.left=DFS();
        root.right=DFS();

        return root;
    }
}
