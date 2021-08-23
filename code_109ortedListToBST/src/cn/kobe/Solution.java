package cn.kobe;

import com.sun.scenario.effect.Brightpass;

public class Solution {
    /*题解厉害，果然现在还是没那个能力直接来做这种*/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private ListNode head;

    public TreeNode conver(int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = start + (end - start) >> 1;
        TreeNode leftTree = conver(start, mid - 1);

        TreeNode newNode = new TreeNode(head.val);
        newNode.left = leftTree;
        head = head.next;
        //中序遍历
        newNode.right = conver(mid + 1, end);

        return newNode;
    }

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int size = 0;
        ListNode p = head;
        while (null != p) {
            p = p.next;
            size++;
        }

        return conver(0, size);
    }
}
