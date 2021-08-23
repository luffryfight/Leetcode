package cn.kobe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class Solution2 {
    //栈方法的数学优化
    public int scoreOfParentheses(String S) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int level = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                stack.push(0);
            else {
                int num = stack.pop();
                int pre = stack.pop();
                stack.push(pre + Math.max(num * 2, 1));
            }
        }
        return stack.pop();
    }
}
