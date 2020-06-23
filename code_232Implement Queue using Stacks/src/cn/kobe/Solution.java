package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    Deque<Integer> stack1=new ArrayDeque<>();//入栈
    Deque<Integer> stack2=new ArrayDeque<>();//出栈
    /** Initialize your data structure here.
    public MyQueue() {

    }*/

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stack2.isEmpty()){//已经转到2中了
            return stack2.pollLast();
        }
        //stack2为空就转换过来
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        return stack2.pollLast();
    }

    /** Get the front element. */
    public int peek() {
        if(!stack2.isEmpty()){//已经转到2中了
            return stack2.peekLast();
        }
        //stack2为空就转换过来
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.peekLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol=new Solution();
        sol.push(1);
        sol.push(2);
        System.out.println(sol.peek());
        System.out.println(sol.pop());
        System.out.println(sol.empty());
    }
}
