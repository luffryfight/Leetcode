package cn.kobe;

import java.util.List;

public class Solution {
    public class ListNode1 {
        int val;
        ListNode1 next;

        ListNode1(int x) {
            val = x;
        }
    }

    public ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        //统计有多少个节点
        ListNode1 p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        if (n == len)
            return head.next;
        p = head;
        while ((--len) > n) {//结束后p指向要删除的节点的前节点
            p = p.next;
        }
        if (n != 1)//不是最后一个节点
            p.next = p.next.next;
        else//最后一个
            p.next = null;
        return head;
    }
}
