package cn.kobe;

public class Solution {
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(val+1);
        dummy.next=head;

        ListNode pre =dummy;
        while(head!=null){
            if(head.val==val){
                pre.next=head.next;
            }else
                pre=pre.next;
            head=pre.next;
        }
        return dummy.next;
    }
}
