package cn.kobe;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) {
              this.val = val; this.next = next;
          }
    }
    public void reorderList(ListNode head) {
        List<ListNode> nodes=new LinkedList<>();
        ListNode ptr=head;
        while(ptr!=null){
            nodes.add(ptr);
            ptr=ptr.next;
        }
        //创建一个新的逆序链表
        int l=nodes.size()-1;
        ListNode newhead=new ListNode(-1);
        ptr=newhead;
        while(head!=null){
            if(nodes.get(l)==head){
                break;
            }
            ListNode temp=head.next;
            ptr.next=head;
            head.next=nodes.get(l);
            head=temp;      l--;
        }

    }
}
