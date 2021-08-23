package cn.kobe;

/**
 * 作用：
 * 2021/1/31
 */
public class Review {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //让一个节点先行n步
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode temp = head, pre = dumy;
        while (n > 0) {
            temp = temp.next;
            n--;
        }
        while (temp != null) {
            temp = temp.next;
            head = head.next;
            pre = pre.next;
        }
        pre.next = head.next;
        return dumy.next;
    }
}
