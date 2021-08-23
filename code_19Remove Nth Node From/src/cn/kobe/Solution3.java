package cn.kobe;

/**
 * 作用:再练习一遍
 * 2020/10/18
 */
public class Solution3 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode slow = pre, fast = head;
        while (fast != null) {
            if (n > 0) {
                fast = fast.next;
                --n;
                continue;
            }
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = fast.next;
        return pre.next;
    }
}
