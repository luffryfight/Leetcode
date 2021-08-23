package cn.kobe;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {//遍历S，遇到左边的就压入对应的，遇到右边的就弹出！
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
