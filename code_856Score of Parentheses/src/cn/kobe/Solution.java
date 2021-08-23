package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static int scoreOfParentheses(String S) {
        Deque<String> stack = new LinkedList<>();//不能是Char,如果是的话，弹出数字就会有问题
        //转换为数组
        char[] str = S.toCharArray();
        int index = 0;//用来判断结束
        for (char s : str) {
            index++;
            if (s == '(')
                stack.push("(");
            else {//s==')'
                String ch;
                int sum = 0;
                while (!stack.isEmpty() && (ch = stack.pop()) != "(") {
                    sum += Integer.parseInt(ch) - 0;
                }
                if (sum == 0) {//()的情况
                    stack.push("1");
                } else {//（A）
                    sum *= 2;
                    stack.push(String.valueOf(sum));
                }
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += Integer.parseInt(stack.pop());
        }
        return res;
    }

    private static int getSum(Deque<Character> stack) {
        return 0;
    }

    public static void main(String[] args) {
        String str = "(()(()()))(()((()))())";
        System.out.println(Solution.scoreOfParentheses(str));
    }
}
