package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solutino {
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
          }
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        //快慢指针结合栈
        Deque<Integer> stack=new ArrayDeque<>();

        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            stack.push(slow.val);
            fast=fast.next.next;
            slow= slow.next;
        }
        if(fast!=null)
            stack.push(slow.val);
        while(!stack.isEmpty()&&slow!=null){
            if(stack.pop()!=slow.val)
                return false;
            slow=slow.next;
        }
        if(stack.isEmpty())
            return slow==null;
        return false;
    }

}
