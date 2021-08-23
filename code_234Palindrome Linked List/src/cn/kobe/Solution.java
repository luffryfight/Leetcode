package cn.kobe;

/**
 * 作用：进阶：O(1）的空间复杂度和O（n）的时间复杂度
 * 需要做的就是反转部分链表，不考虑恢复（参考）
 * 2020/10/23
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 1->2->3
    public boolean isPalindrome(ListNode head) {
        ListNode pre = null, slow = head, fast = head;
        //寻找中间节点的同时，反转前半部分
        while (fast != null && fast.next != null) {
            ListNode next = slow.next;
            if (pre != null) slow.next = pre;//这里必须判断
            pre = slow;
            fast = fast.next.next;
            slow = next;
        }
        //如果节点个数是奇数
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (slow.val != pre.val) return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
