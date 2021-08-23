package cn.kobe;

import java.util.LinkedList;
import java.util.List;

//这里写的居然是错的
public class Solution {
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

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> nodes = new LinkedList<>();
        ListNode ptr = head;
        while (ptr != null) {
            nodes.add(ptr);
            ptr = ptr.next;
        }
        //创建一个新的逆序链表
        int i = 0, j = nodes.size() - 1;
        while (i < j) {
            nodes.get(i).next = nodes.get(j);
            i++;//比如 1 2 3 4 会出先 i++后等于i=3 j=3;所以提前判断一下
            if (i == j) break;
            nodes.get(j).next = nodes.get(i);
            j--;
        }
        nodes.get(i).next = null;
    }
}
