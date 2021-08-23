package cn.kobe;

import sun.applet.AppletResourceLoader;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //第一感觉是先读出数据，然后再数组上操作。。
    public ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode ptr = head;
        while (ptr != null) {
            list.add(ptr.val);
            ptr = ptr.next;
        }
        return null;
    }
}
