package cn.kobe;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*因为之前遇见过，所以做起来还是很简单*/
    //也可以用hashmap保存做！
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {//避免空指针异常
            fast = fast.next.next;
            low = low.next;
            if (low == fast)
                return true;
        }
        return false;
    }
}
