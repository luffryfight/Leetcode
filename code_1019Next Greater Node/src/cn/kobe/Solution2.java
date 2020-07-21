package cn.kobe;

import java.util.Stack;

class Solution2 {
    class ListNode {
        int val;
        Solution.ListNode next;
        ListNode(int x) { val = x; }
    }
    public int[] nextLargerNodes(ListNode head) {
        int[] arr = new int[10000];
        int[] valueArr = new int[10000];

        Stack<Integer> stack = new Stack<>();
        int length = 0;
        int value;
        while (head != null) {
            value = head.val;
            valueArr[length] = value;
            while (!stack.isEmpty() && value > valueArr[stack.peek()]) {
                arr[stack.pop()] = value;
            }
            stack.add(length);
            length++;
            //head = head.next;
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
