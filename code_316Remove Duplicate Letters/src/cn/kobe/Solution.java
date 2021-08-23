package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /*记住这几道题一个类型的：*/
    //其实这题也不难，自己做出来了
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        //特殊情况
        if (len < 2) return s;
        //创建栈
        Deque<Character> stack = new ArrayDeque<>();
        //加入哨兵
        stack.addLast('a');//最小的,因为题目要求字典序
        //判断结果串中是否已经存在该字符，即不用再处理该字符
        boolean[] isAbsent = new boolean[26];
        //创建字典,保存最后一次出现的位置
        int[] lastIndex = new int[26];
        int x = 0;
        for (char ch : s.toCharArray()) {
            lastIndex[ch - 'a'] = x;
            x++;
        }

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (isAbsent[ch - 'a']) continue;
            while (ch < stack.peekLast() && lastIndex[stack.peekLast() - 'a'] >= i) {
                isAbsent[stack.removeLast() - 'a'] = false;
            }
            stack.addLast(ch);
            isAbsent[ch - 'a'] = true;
        }
        //将结果导出来
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size - 1; i++) {
            sb.append(stack.pollLast());
        }
        return sb.reverse().toString();
    }
}
