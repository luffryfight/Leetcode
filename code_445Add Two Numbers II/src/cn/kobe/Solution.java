package cn.kobe;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.Stack;

public class Solution {
    //基础版本：先反转链表，然后计算
    //还有进阶版本
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
    //反正需要考虑逆序的情况都可以考虑考虑栈
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode res = null;
        int c = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || c > 0) {
            int sum = (s1.isEmpty() ? 0 : s1.pop()) +
                    (s2.isEmpty() ? 0 : s2.pop()) + c;
            ListNode n = new ListNode(sum % 10);
            c = sum / 10;
            n.next = res;
            res = n;
        }
        return res;
    }
}
