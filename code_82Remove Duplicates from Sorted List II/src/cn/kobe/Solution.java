package cn.kobe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new LinkedList<>();
        if (null == head)
            return head;
        ListNode temp = head;
        while (temp.next != null) {
            int next = temp.next.val;
            if (temp.val == next) {
                temp.next = temp.next.next;
                list.add(temp.val);
            } else
                temp = temp.next;
        }
        //新建一个节点,因为可能要删除第一个节点
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        while (newNode.next != null) {
            if (list.contains(temp.next.val))
                newNode.next = newNode.next.next;
            else
                newNode = newNode.next;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        System.out.println(Solution.deleteDuplicates(l));
    }
}
