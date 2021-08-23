package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

//一个栈
public class MinStack3 {
    //stack[i]和min的关系  stack[i]+min = val[i]
    long min = Integer.MAX_VALUE;
    Deque<Long> stack = new ArrayDeque<>();//可以利用原有的

    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(x - min);
        } else {
            stack.push(x - min);
            min = Math.min(min, x);
        }
    }

    public int top() {
        long top = stack.peek();
        if (top >= 0) {
            return (int) (top + min);
        } else
            return (int) (min);
    }

    public void pop() {
        /*if(stack.isEmpty())
            return;*/
        long x = stack.pop();
        if (x < 0) {
            min = min - x;
        }
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] args) {
        MinStack3 ms = new MinStack3();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        ms.top();
        System.out.println(ms.getMin());
    }
}
