package cn.kobe;

public class Solution2 {
    //使用两个间隔n的快慢指针，就可以得到倒数第n个
    //0[ 1 2 3 4 5
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode pre=new ListNode(0);pre.next=head;
        ListNode first=pre,tail=head;
        while(tail.next!=null){
            if(n<=1)
                first=first.next;
            tail=tail.next;n--;
        }
        first.next=first.next.next;
        return pre.next;
    }
}
