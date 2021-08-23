package cn.kobe;

/**
 * 作用：空间复杂度O（1）
 * 2020/10/15
 */
public class Solution2 {
    Node nextStart = null, last = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            nextStart = null;
            last = null;
            for (Node temp = start; temp != null; temp = temp.next) {
                if (temp.left != null)
                    getNext(temp.left);
                if (temp.right != null)
                    getNext(temp.right);
            }
            start = nextStart;
        }
        return root;
    }

    public void getNext(Node p) {
        System.out.println(p.val);
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
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
