package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/4/23 14:27
 */
public class Review {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> min = new ArrayDeque<>();

    /**
     * initialize your data structure here.
     */
    public Review() {

    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty()) {
            min.push(val);
        } else {
            if (val < min.peek()) {
                min.push(val);
            } else
                min.push(min.peek());
            //min.push(val<min.top()?val:min.top());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
