package cn.kobe;

import java.util.*;

public class Solution {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    Map<Integer,Node> buckets=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        return dfs(node);
    }
    private Node dfs(Node head){
        System.out.print(head.val+" ");
        if(buckets.containsKey(head.val))
            return buckets.get(head.val);
        Node newNode=new Node(head.val);

        buckets.put(head.val,newNode);
        for(Node ch:head.neighbors){//因为是连通的所以可以访问到所有节点
            newNode.neighbors.add(dfs(ch));
        }
        return newNode;
    }
}
