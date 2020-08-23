package cn.kobe;

import java.util.List;

public class Solution {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }

         ListNode(int val, ListNode next) {
             this.val = val; this.next = next;
         }
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        //先连接奇数后连接偶数
        ListNode dummy=new ListNode(-1);

        ListNode temp=dummy;
        ListNode ptr=head;

        while(ptr!=null){
            temp.next=ptr;
            temp=ptr;
            if(ptr.next!=null&&ptr.next.next!=null)
                ptr=ptr.next.next;
            else break;
        }
        ptr=head.next;
        while(ptr!=null){
            temp.next=ptr;
            temp=ptr;
            if(ptr.next!=null&&ptr.next.next!=null)
                ptr=ptr.next.next;
            else break;
        }

        temp.next=null;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution so=new Solution();
        ListNode node=new ListNode(1);
        ListNode temp=node;
        for(int i=2;i<6;i++){
            temp.next=new ListNode(i);
            temp=temp.next;
        }
        so.oddEvenList(node);
    }
}
