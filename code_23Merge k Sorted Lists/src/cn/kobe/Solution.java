package cn.kobe;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1)
            return lists[0];
        else if (lists.length == 0)
            return null;
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwoList(res, lists[i]);
        }
        return res;
    }

    //先合并两个电影
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
