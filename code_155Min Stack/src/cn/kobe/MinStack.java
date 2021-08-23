package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

//一个栈
public class MinStack {
    /*
     * 方法很巧妙啊。。。。
     * 两种只用一个栈的方法，重点在处理min的处理上。。感觉是废话。。
     * （一种是储存，一种是使用差值）
     * 链式栈的好处这里就体现了，可以在链表的属性中添加min条件，记住这个优点！
     *
     * */
    int min = Integer.MAX_VALUE;
    Deque<Integer> stack = new ArrayDeque<>();//可以利用原有的

    public void push(int x) {
        if (x <= min) {//意思就是当出现更小的元素时就再压入一次上一个min
            stack.push(min);//这里要注意下，push和add的区别，add在最前面
            min = x;
        }
        stack.push(x);
    }

    public int top() {
        return stack.peek();
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int getMin() {
        return min;
    }
}
