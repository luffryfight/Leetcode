package cn.kobe;

public class MinStack2 {
    /*
     * 采用链式栈
     * */
    class Node {
        int x;
        int min;
        Node next;

        public Node(int x, int min) {
            this.x = x;
            this.min = min;
            next = null;
        }
    }

    //指针head
    Node head;

    /**
     * initialize your data structure here.
     * public MinStack2() {
     * <p>
     * }
     */

    //头插法，可以表现栈的性质
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            Node temp = new Node(x, Math.min(x, head.min));
            temp.next = head;
            head = temp;
        }


    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        if (head != null) {
            return head.x;
        }
        return -1;
    }

    public int getMin() {
        if (head != null) {//不为空
            return head.min;
        }
        return -1;
    }
}
