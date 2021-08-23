package cn.kobe;

import java.util.HashMap;

public class Solution2 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //solution1是o(N)的空间复杂度
    //先O（1）
    //原理就是，。。。看官方题解三吧
    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        //先在每个节点后面创建一个虚拟节点
        Node ptr = head;
        while (ptr != null) {
            Node newNode = new Node(ptr.val);
            //连接
            newNode.next = ptr.next;
            ptr.next = newNode;
            //下一个
            ptr = ptr.next;
        }
        //处理随机指针
        ptr = head;
        while (ptr != null) {
            ptr.next.random = ptr.random != null ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        //连接新的链表
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }

}
