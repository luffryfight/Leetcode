package cn.kobe;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack=new ArrayDeque<>();
        //压栈和出栈的过程比较耗时间
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] res=new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=stack.pop();
        }
        return res;
    }
}
