package leetcode;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Stack;

public class Solution2 {
    /*
     * 6.14重做，用栈的方法！思路很简单！参考84题
     * */
    public int trap(int[] height) {
        if (height.length < 1) return 0;
        //stack保存下标是因为需要宽度！
        Stack<Integer> stack = new Stack();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int index = stack.pop();
                //弹出相等的栈顶元素，直到比index对应的值大
                while (!stack.isEmpty() && height[stack.peek()] == height[index]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {//不为空
                    //注意下面高度和宽度的计算
                    int wideth = i - stack.peek() - 1;//是当前的i
                    int high = Math.min(height[stack.peek()], height[i]) - height[index];
                    res += wideth * high;
                }
            }
            stack.add(i);
        }
        return res;
    }

}
