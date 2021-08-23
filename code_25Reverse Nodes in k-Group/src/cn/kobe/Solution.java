package cn.kobe;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    // example 0 --- 1->2->3->5->6->7

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;
        ListNode end = head;
        while (end != null) {
            count++;
            if (count % k == 0) {
                /**注意传入的区间是 (start,end]**/
                start = reverse(start, end);
                end = start.next;
            } else {
                end = end.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode next = start.next;
        ListNode head = next;
        while (next != end) {
            ListNode temp = next.next;// example 0 --- 1->2->3->5->6->7
            next.next = prev;
            prev = next;
            next = temp;
        }
        start.next = prev;//将反转后的最后一个节点与前节点相连
        head.next = next;//指向的是节点
        return head;
    }
}
