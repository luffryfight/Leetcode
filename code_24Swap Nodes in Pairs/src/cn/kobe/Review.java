package cn.kobe;

/**
 * 作用：复习
 * 2021/2/3
 */
public class Review {
    public static class ListNode {
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

    public ListNode swapPairs(ListNode head) {
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode temp = dumy;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            ListNode pre = next.next;
            temp.next = next;
            head.next = pre;
            next.next = head;
            next.next = head;
            temp = temp.next.next;
            head = head.next;
        }
        return dumy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        Review review = new Review();
        review.swapPairs(head);
    }
}
