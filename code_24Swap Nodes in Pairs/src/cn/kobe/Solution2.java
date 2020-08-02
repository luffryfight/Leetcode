package cn.kobe;

public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //用递归做！
    public ListNode swapPairs(ListNode head){
        if((head==null)||(head.next==null)){
            return head;
        }
        //创建虚拟头节点！
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        //找到要交换的两个节点
        ListNode first=head;
        ListNode second=head.next;
        //swap
        dummy.next=second;
        first.next=second.next;
        second.next=first;
        if(first.next!=null)
        first.next=swapPairs(first.next);

        //1 2 3 4 5 6
        return dummy.next;
    }

}
