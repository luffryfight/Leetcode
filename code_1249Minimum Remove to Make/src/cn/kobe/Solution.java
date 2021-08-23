package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char chs = 0;
        int level = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                level++;
            else
                level--;
            if (ch == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && (chs = stack.pop()) != '(')
                    sb.append(chs);
                if (chs == '(')
                    sb.append('(');
                for (char c : sb.reverse().toString().toCharArray())
                    stack.push(c);
                //如果没找到（就是无效的
                if (level > 0)
                    continue;
            }
            stack.push(ch);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.append(stack.pop());
        return res.reverse().toString();
    }
}
