package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 1; i < S.length(); i++) {
            if (isValid(S.substring(start, i + 1))) {
                sb.append(S.substring(start + 1, i));
                start = i + 1;
            }
        }
        return sb.toString();
    }

    private static boolean isValid(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(')
                stack.push(ch);
            else if (ch == ')' && '(' != stack.pop())
                return false;
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(Solution.removeOuterParentheses("()()"));
    }
}
