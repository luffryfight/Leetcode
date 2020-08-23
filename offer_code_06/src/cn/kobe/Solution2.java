package cn.kobe;

class Solution2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //原理差不多
    public int[] reversePrint(ListNode head) {
        int len=0;
        ListNode temp = head;
        //获取链表长度
        while (temp != null){
            len++;
            temp = temp.next;
        }
        int[] a = new int[len];
        temp = head;
        //反向获取链表数据
        for (int i = len-1;i >= 0;i--){
            a[i] = temp.val;
            temp = temp.next;
        }
        return a;
    }
}
