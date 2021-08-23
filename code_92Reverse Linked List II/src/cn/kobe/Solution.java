package cn.kobe;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*因为才做了25题，直接用它的反转函数*/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;//start是前节点
        ListNode end = head;
        int sindex = 0, eindex = 1;//若eindex=0，就不用+1
        while (end != null) {
            eindex++;
            sindex++;
            end = end.next;//寻找end的位置
            if (eindex == n + 1) {//注意是+1
                start = reverse(start, end);//1->2->3->4->5->NULL, m = 2, n = 4
                end = start.next;
                break;
            }
            if (sindex < m) {//寻找start的位置
                start = start.next;
            }
        }
        return dummy.next;
    }

    //传入下一个节点的原因：在这个函数中已经反转并重新连接了链表
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode next = start.next;
        ListNode head = next;
        while (next != end) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        start.next = prev;//将反转后的最后一个节点与前节点相连
        head.next = next;//指向的是节点
        return head;
    }
}
