package cn.kobe;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //转换位数组来做,通过旋转数组来旋转链表
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;len++;
        }
        int[] save=new int[len];
        int[] res=new int[len];
        //保存到数组中
        temp=head;len=0;
        while(temp!=null){
            save[len++]=temp.val;
            temp=temp.next;
        }
        for (int i = 0; i < len; i++) {
            int pos=(i+k)%len;
            res[pos]=save[i];
        }
        temp=head;len=0;
        while(temp!=null){
            temp.val=res[len++];
            temp=temp.next;
        }
        return head;
    }
}
