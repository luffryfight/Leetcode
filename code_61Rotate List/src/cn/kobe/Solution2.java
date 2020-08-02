package cn.kobe;

import java.sql.PreparedStatement;

public class Solution2 {
    //保存在数组中未免也太麻烦了其实
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode temp=head;
        int len=1;//节点个数
        for(;temp.next!=null;len++)
            temp=temp.next;
        //连接头尾
        temp.next=head;

        for (int i = 0; i < (len-k) % (len-1); i++) {
            head=head.next;
        }
        ListNode newhead=head.next;
        head.next=null;
        return newhead;
    }
}
