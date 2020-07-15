package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static String removeDuplicates(String S) {
        //转换成数组
        char[] str= S.toCharArray();
        //创建栈
        Deque<Character> stack=new ArrayDeque<>();
        for (char ch:str) {
            if(!stack.isEmpty()&&stack.peek()==ch)
                stack.pop();
            else
                stack.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        int size=stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution2.removeDuplicates("abbbbbbbaccca"));
    }
}
