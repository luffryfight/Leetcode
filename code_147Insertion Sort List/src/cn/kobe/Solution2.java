package cn.kobe;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //第一感觉是先读出数据，然后再数组上操作。。
    public ListNode insertionSortList(ListNode head) {
        //创建虚拟头节点
        ListNode dummy = new ListNode(0);
        //dummy.next=head;

        ListNode pre = dummy;//前节点
        for (ListNode node = head; node != null; ) {
            //临时节点
            ListNode curr = node;
            //因为 curr可能会改变，所以先保存临时节点和移到下一个
            node = node.next;
            //如果上一次的pre.val 大于 curr.val ，就应该从头开始
            if (curr.val < pre.val) pre = dummy;//

            while (pre.next != null && pre.next.val < curr.val) pre = pre.next;

            //相当于重构新链表，然后将每个节点连接上去；
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }
}
