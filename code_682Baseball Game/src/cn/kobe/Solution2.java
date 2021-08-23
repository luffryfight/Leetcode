package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        //思路简单。。。
        for (String str : ops) {
            if ("C".equals(str)) {
                stack.pop();
            } else if ("D".equals(str)) {
                stack.push(stack.peek() * 2);
            } else if ("+".equals(str)) {
                int prenum = stack.pop();
                int newNum = stack.peek() + prenum;
                stack.push(prenum);
                stack.push(newNum);
            } else
                stack.push(Integer.parseInt(str));
        }
        for (int ch : stack) res += ch;
        return res;
    }
}
