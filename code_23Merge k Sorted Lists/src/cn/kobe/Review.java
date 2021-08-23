package cn.kobe;

/**
 * 作用：分治思想
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

    //思路：利用之前写过的函数，合并两个有序列表，合并K个就两两合并！
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        } else if (len == 1) {
            return lists[0];
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            dumy.next = mergeTwoLists(dumy.next, lists[i]);
        }
        return dumy.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumy = new ListNode(-1);
        ListNode temp = dumy;
        while (l1 != null && l2 != null) {
            int num1 = l1.val, num2 = l2.val;
            if (num1 < num2) {
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
