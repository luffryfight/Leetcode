package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    Deque<Integer> queue = new ArrayDeque<>();

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.push(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        for (int i = 0; i < queue.size(); i++) {
            queue.push(queue.pollFirst());
        }
        return queue.pollFirst();
    }

    /**
     * Get the top element.
     */
    public int top() {
        for (int i = 0; i < queue.size(); i++) {
            queue.push(queue.pollFirst());
        }
        int res = queue.pollFirst();
        queue.push(res);
        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
