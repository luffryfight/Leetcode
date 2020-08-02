package cn.kobe;

import java.util.List;

public class Solution {

    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        //必须要一个虚拟节点和前节点保存，因为必须连接后面的
        ListNode temp=dummy;
        while((null!=head)&&(null!=head.next)){
            ListNode prev=head;
            ListNode next=head.next;
            //swap
            temp.next=next;
            prev.next=next.next;
            next.next=prev;
            //更新
            temp=prev;
            head=prev.next;//为啥这里换成head=temp.next;

        }
        return dummy.next;
    }
}
