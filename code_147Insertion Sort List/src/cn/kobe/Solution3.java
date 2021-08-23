package cn.kobe;

/**
 * 作用：练习回顾
 * 2020/11/20
 */
public class Solution3 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //第一感觉是先读出数据，然后再数组上操作。。
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (head != null) {
            ListNode curr = head;
            head = head.next;
            if (curr.val < pre.val) {
                pre = dummy;//重定位
            }
            //找到对应位置
            while (pre.next != null && pre.next.val < curr.val) pre = pre.next;
            //更新
            curr.next = pre.next;
            pre.next = curr;

        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode two = new ListNode(2);
        head.next = two;
        ListNode three = new ListNode(1);
        two.next = three;
        ListNode four = new ListNode(3);
        three.next = four;
        Solution3 solution3 = new Solution3();
        solution3.insertionSortList(head);
    }
}
