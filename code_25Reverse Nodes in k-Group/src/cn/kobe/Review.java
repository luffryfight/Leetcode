package cn.kobe;

/**
 * 作用：
 * 2021/2/3
 */
public class Review {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) return head;
        ListNode dumy = new ListNode(-1);
        dumy.next = head;

        int count = 0;
        ListNode start = dumy, end = head;
        while (end != null) {
            count++;
            if (count % k == 0) {
                start = reverse(start, end.next);//注意是end.next 即反转范围是：（start,end]
                end = start.next;
            } else {
                end = end.next;
            }
        }
        return dumy.next;
    }

    /**
     * for example:
     * 0->1->2->3->4->5->6->7->8
     * |           |
     * start       end
     * After call start = reverse(start, end)
     * 0->3->2->1->4->5->6->7->8
     * -     |  |
     * start end
     * first
     */
    public ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode temp = start.next, res = start.next;
        while (temp != end) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        start.next = prev;//相当于把0->3 当k=3时
        res.next = temp;
        return res;
    }
}
