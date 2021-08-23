package cn.kobe;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 作用：层序遍历
 * 2020/10/15
 */
public class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node last = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                temp.next = last;
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                last = temp;
            }
        }
        return root;
    }

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
}
