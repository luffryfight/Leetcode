package cn.kobe;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 作用：
 * 2021/2/3
 */
public class Review2 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        } else if (len == 1) {
            return lists[0];
        }
        ListNode dumy = new ListNode(-1);
        ListNode temp = dumy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode next = queue.poll();
            temp.next = next;
            temp = temp.next;
            if (next.next != null) {
                queue.add(next.next);
            }
        }
        return dumy.next;
    }
    /*
     * 最优版本！：分治合并：把8个list合并为4个再合并为2个！减少了很多步骤
     * */
    /*
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null){ return null;}
            if(lists.length == 0){ return null;}
            if(lists.length == 1){ return lists[0];}
            return merge(lists,0,lists.length-1);
        }
        public ListNode merge(ListNode[] lists,int left,int right){
            if(left == right){ return lists[left];}
            int mid = left + (right - left)/2;
            return mergeTwoLists(merge(lists,left,mid),merge(lists,mid+1,right));
        }
    * */
}
