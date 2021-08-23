package cn.kobe;

public class Solution2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //题目要求是返回节点,还是用快慢指针
    //原理见下面的推导
    //https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/
    // linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, low = head;
        while (true) {//避免空指针异常
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            low = low.next;
            if (low == fast) break;
        }

        fast = head;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
