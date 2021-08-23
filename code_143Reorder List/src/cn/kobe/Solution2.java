package cn.kobe;

import java.util.LinkedList;
import java.util.List;

/**
 * 作用：
 * 2020/10/20
 */
public class Solution2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            list.addLast(temp);
            temp = temp.next;
        }
        temp = head;
        int len = list.size() - 1;
        ListNode root = new ListNode(-1);
        temp = root;
        while (head != null) {
            if (list.get(len) == head) {
                break;
            }
            ListNode next = head.next;
            temp.next = head;
            head.next = list.get(len);
            head = next;
            len--;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode temp = root;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        Solution2 solution2 = new Solution2();
        solution2.reorderList(root);
        int a = 0;
    }
}
