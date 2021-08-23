package cn.kobe;

import javafx.scene.transform.Shear;

import java.lang.reflect.AnnotatedArrayType;
import java.util.HashMap;
import java.util.logging.Handler;

public class Solution {
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

    /*复制时遇到的问题在于，当你遍历时randrom指向的节点可能
     * 为之前已经创建的节点(此时直接new不行！)
     * 解决方案：创建一个字典，将访问过的节点放入，存在直接引用*/
    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        //用来遍历的
        Node oldNode = head;
        Node newNode = new Node(head.val);
        map.put(oldNode, newNode);

        while (oldNode != null) {
            //调用字典
            newNode.next = getNode(oldNode.next);
            newNode.random = getNode(oldNode.random);
            //下一个
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        //获取head指向的为了防止新的链表的head是原来的；
        return map.get(head);
    }

    private Node getNode(Node node) {
        if (node != null) {//该节点中存在
            if (map.containsKey(node)) {//字典中存在
                return map.get(node);
            } else {
                map.put(node, new Node(node.val));
                return map.get(node);
            }
        }
        return null;
    }

}
