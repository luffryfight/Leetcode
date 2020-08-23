package cn.kobe;

public class Solution2 {
    //看这个题解就直到为啥叫综合性题了
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head){
        //分治法，先分为两个表，排序为有序表，合并有序表，
        if(head==null||head.next==null)
            return head;
        ListNode temp=middleNode(head);
        ListNode right=temp.next;
        temp.next=null;//断开

        ListNode l=sortList(head);
        ListNode r=sortList(right);
        //合并两个表
        return mergeTwoLists(l,r);
    }
    //  找到链表中间节点（876. 链表的中间结点）
    private ListNode middleNode(ListNode head){
        if(head==null||head.next==null)
            return head;
        //快慢指针
        ListNode slow=head;
        ListNode fast=head.next.next;
        while (fast != null && fast.next != null) {
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    // 合并两个有序链表（21. 合并两个有序链表）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;
            }else {
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        temp.next= l1==null?l2:l1;
        return dummy.next;
    }

}
