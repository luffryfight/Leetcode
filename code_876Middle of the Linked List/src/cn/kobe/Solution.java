package cn.kobe;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*快慢指针*/
    //10分钟
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //可能fast在倒数第二个
        System.out.println(fast.val);
        if (fast.next != null)
            return slow.next;
        return slow;
    }
}
