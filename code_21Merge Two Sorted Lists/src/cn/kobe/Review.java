package cn.kobe;

/**
 * 作用：
 * 2021/1/31
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

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dumy = new ListNode(-1);
        ListNode temp = dumy;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 101 : l1.val;
            int num2 = l2 == null ? 101 : l2.val;
            if (num1 < num2) {
                temp.next = new ListNode(num1);
                l1 = l1.next;
            } else {
                temp.next = new ListNode(num2);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return dumy.next;
    }

    //这俩做法差距还是很大的
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumy = new ListNode(-1);
        ListNode temp = dumy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return dumy.next;
    }
}
