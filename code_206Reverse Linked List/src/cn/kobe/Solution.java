package cn.kobe;

import netscape.security.UserTarget;

public class Solution {
    /*本题可以参考92或者25*/
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode end=head;
        while(end!=null){//找到最后一个空节点
            end=end.next;
        }

        reverse(dummy,end);
        return dummy.next;
    }
    //感觉可以把这个函数记下来
    private ListNode reverse(ListNode start,ListNode end){
        //函数返回的是最后一个节点的前一个节点（此时以及都反转了）
        ListNode prev=start;
        ListNode next=start.next;
        ListNode head=next;
        while (next!=end){
            ListNode temp=next.next;
            next.next=prev;
            prev=next;
            next=temp;
        }
        start.next=prev;
        head.next=next;//第一个节点指向空（尾部处理！）
        return head;
    }


}
