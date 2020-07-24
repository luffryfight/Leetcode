package cn.kobe;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //我去，还有传入空参数的，，
    public ListNode deleteDuplicates(ListNode head) {
        if(null==head)
            return head;
        ListNode temp=head;
        while(temp.next!=null){
            if(temp.val==temp.next.val)
                temp.next=temp.next.next;
            else{
                temp=temp.next;
            }
        }
        return head;
    }
}
