package cn.kobe;

public class Solution3 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode pre = temp.next;
            ListNode next = temp.next.next;//下一组
            pre.next = next.next;
            temp.next = next;
            next.next = pre;
            temp = pre;
        }
        return dummy.next;
    }
}
