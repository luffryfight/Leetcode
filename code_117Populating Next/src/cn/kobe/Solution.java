package cn.kobe;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    //层序遍历
    //久了不刷题真的不行啊
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {//注意一下这里
            Node pre = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node ch = queue.poll();
                ch.next = pre;
                if (ch.right != null)
                    queue.add(ch.right);
                if (ch.left != null)
                    queue.add(ch.left);
                pre = ch;
            }
        }
        return root;
    }
}
